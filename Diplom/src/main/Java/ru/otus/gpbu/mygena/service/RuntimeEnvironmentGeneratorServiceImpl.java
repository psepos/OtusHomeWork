package ru.otus.gpbu.mygena.service;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.service.runtime.PathService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class RuntimeEnvironmentGeneratorServiceImpl implements RuntimeEnvironmentGeneratorService {

    @Autowired
    private final PathService pathService;

    public RuntimeEnvironmentGeneratorServiceImpl(PathService pathService) {
        this.pathService = pathService;
    }

    @Override
    public void clearTargetDirectory() {

    }

    @Override
    public void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException {
        Path templateFile = pathService.environmentTemplateFileWithPath();
        log.debug("copyTemplateEnvironmentToTargetDirectory():templateFile: " + templateFile);

        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();
        log.debug("copyTemplateEnvironmentToTargetDirectory():destinationFile: " + destinationFile);

        Files.copy(templateFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public void unzipTemplateEnvironment() throws ZipException {
        Path destinationPath = pathService.runtimeEnvironmentDestinationPath();
        log.debug("unzipTemplateEnvironment():destinationPath = " + destinationPath);

        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();
        log.debug("unzipTemplateEnvironment():destinationFile = " + destinationFile);

        new ZipFile(destinationFile.toFile()).extractAll(destinationPath.toString());
    }

    @Override
    public void compileAndBuildRuntimeStep() throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(
                "cmd /c mvnw.cmd package -T 1C -o -am -Dmaven.test.skip > " + pathService.compileLog(),
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString()));

        process.waitFor();

        if (process.exitValue() != 0) {
            log.error("Error building runtime");
        }

    }
}
