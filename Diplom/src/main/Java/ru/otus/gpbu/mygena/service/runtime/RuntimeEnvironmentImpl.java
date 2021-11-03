package ru.otus.gpbu.mygena.service.runtime;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class RuntimeEnvironmentImpl implements RuntimeEnvironment {

    @Autowired
    private final PathService pathService;

    public RuntimeEnvironmentImpl(PathService patches) {
        this.pathService = patches;
    }

    @Override
    public void prepare() throws Exception {
        this.clear();
        this.copyTemplate();
        this.unzipTemplate();
        this.deleteTemplate();
    }

    @Override
    public void compile() throws InterruptedException, IOException {

        Process process = Runtime.getRuntime().exec(
                "cmd /c mvnw.cmd clean package > " + pathService.compileLog(),
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString()));

        process.waitFor();

        if (process.exitValue() != 0) {
            System.out.println("Error building runtime");
        }
    }

    @Override
    public void run() throws InterruptedException, IOException {

        Process process = Runtime.getRuntime().exec(
                "cmd /c start java -jar " + pathService.artifactFileName(),
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString() + "\\target"));

        process.waitFor();
    }

    private void clear() {

    }

    private void copyTemplate() throws URISyntaxException, IOException {
        Path templateFile = pathService.environmentTemplateFileWithPath();
        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();

        Files.copy(templateFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private void deleteTemplate() throws IOException {
        Files.deleteIfExists(pathService.runtimeEnvironmentDestinationFileWithPath());
    }

    private void unzipTemplate() throws ZipException {

        Path destinationPath = pathService.runtimeEnvironmentDestinationPath();
        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();

        new ZipFile(destinationFile.toFile()).extractAll(destinationPath.toString());
    }



}
