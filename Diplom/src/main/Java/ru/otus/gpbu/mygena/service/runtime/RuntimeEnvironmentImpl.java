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

    @Autowired
    private final GeneratorService gena;

    public RuntimeEnvironmentImpl(PathService patches, GeneratorService gena) {
        this.pathService = patches;
        this.gena = gena;
    }

    @Override
    public void generate() throws Exception {
        this.runtimePrepare();
        this.gena.start();
        this.runtimeCompile();
    }

    @Override
    public void run() throws InterruptedException, IOException {

        Process process = Runtime.getRuntime().exec(
                "cmd /c start java -jar " + pathService.artifactFileName(),
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString() + "\\target"));

        process.waitFor();
    }

    private void runtimePrepare() throws Exception {
        this.clear();
        this.copyTemplate();
        this.unzipTemplate();
        this.deleteTemplate();
    }

    private void runtimeCompile() throws InterruptedException, IOException {

        Process process = Runtime.getRuntime().exec(
                "cmd /c mvnw.cmd package -T 1C -o -am -Dmaven.test.skip > " + pathService.compileLog(),
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString()));

        process.waitFor();

        if (process.exitValue() != 0) {
            System.out.println("Error building runtime");
        }
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
