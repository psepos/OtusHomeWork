package ru.otus.gpbu.earth.service;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;
import ru.otus.gpbu.earth.service.runtime.BuildFaultException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class MoonRuntimeOperationsImpl implements MoonRuntimeOperations {

    @Autowired
    private final PathService pathService;

    @Autowired
    private final MySettingService settings;

    public MoonRuntimeOperationsImpl(PathService pathService, MySettingService settings) {
        this.pathService = pathService;
        this.settings = settings;
    }

    @Override
    public void clearTargetDirectory() throws IOException {

        Path destination = pathService.runtimeEnvironmentDestinationPath();
        log.debug("destination = {}", destination);

        if (Files.exists(destination)) {
            log.debug("destination exists");

            boolean result = FileSystemUtils.deleteRecursively(pathService.runtimeEnvironmentDestinationPath());
            log.debug("delete result = {}", result);
        }

        boolean result = destination.toFile().mkdir();
        log.debug("mkdir result = {}", result);

    }

    @Override
    public void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException {
        Path templateFile = pathService.environmentTemplateFileWithPath();
        log.debug("copyTemplateEnvironmentToTargetDirectory():templateFile: {}", templateFile);


        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();
        log.debug("copyTemplateEnvironmentToTargetDirectory():destinationFile: {}", destinationFile);

        Files.copy(templateFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public void unzipTemplateEnvironment() throws IOException {
        Path destinationPath = pathService.runtimeEnvironmentDestinationPath();
        log.debug("unzipTemplateEnvironment():destinationPath = {}", destinationPath);

        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();
        log.debug("unzipTemplateEnvironment():destinationFile = {}", destinationFile);

        new ZipFile(destinationFile.toFile()).extractAll(destinationPath.toString());
        Files.deleteIfExists(destinationFile);
    }

    @Override
    public void compileAndBuildRuntimeStep() throws InterruptedException, IOException, BuildFaultException {


        String command = this.getCommand();



        log.debug("compileAndBuildRuntimeStep(): command = {}", command);

        log.info("Begin Maven build");

        Process process = Runtime.getRuntime().exec(
                command,
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString()));

        process.waitFor();

        log.info("End Maven build");

        var exitValue = process.exitValue();
        if (exitValue != 0) {
            log.error("Fault building the runtime. error code {}", exitValue);
            throw new BuildFaultException();
        }

    }

    private String getCommand() {

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        String command;

        if (isWindows) {
            // Windows
            command = "cmd /c";
        } else {
            // Linux
            command = "sh /c";
        }

        command += String.format(" mvn %s", settings.getSetting("RUNTIME.ENVIRONMENT.COMPILE.MAVEN_BUILD_OPTIONS"));

        if (settings.getSettingBool("RUNTIME.ENVIRONMENT.COMPILE.MAVEN_SKIP_TESTS")) {
            command += " -Dmaven.test.skip";
        }

        command = String.format("%s > %s", command, pathService.compileLog());

        return command;
    }

}
