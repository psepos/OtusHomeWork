package ru.otus.gpbu.earth.service;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
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
public class MoonGeneratorServiceImpl implements MoonGeneratorService {

    @Autowired
    private final PathService pathService;

    @Autowired
    private final MySettingService settings;

    public MoonGeneratorServiceImpl(PathService pathService, MySettingService settings) {
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
    public void compileAndBuildRuntimeStep() throws InterruptedException, IOException, BuildFaultException {

        String command;

        /*
        if (settings.getSettingBool("RUNTIME.ENVIRONMENT.COMPILE.OPEN_COMPILE_WINDOW")) {
            command = "cmd /c start mvnw.cmd";
        } else {
            command = "cmd /c mvnw.cmd";
        }
        */
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        if (isWindows) {
            command = "cmd /c";
        } else {
            command = "sh /c";
        }

        command = command + " mvn";

        command = command + " " + settings.getSetting("RUNTIME.ENVIRONMENT.COMPILE.MAVEN_BUILD_OPTIONS");

        if (settings.getSettingBool("RUNTIME.ENVIRONMENT.COMPILE.MAVEN_SKIP_TESTS")){
            command = command + " -Dmaven.test.skip";
        }

        command = command + " > " + pathService.compileLog();

        log.debug("compileAndBuildRuntimeStep(): command = {}", command);

        Process process = Runtime.getRuntime().exec(
                command,
                null,
                new File(pathService.runtimeEnvironmentDestinationPath().toString()));

        process.waitFor();

        var exitValue = process.exitValue();
        if (exitValue != 0) {
            log.error("Fault building the runtime. error {}",exitValue);
            throw new BuildFaultException();
        }

    }

    @Override
    public JavaFile doEntityGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.entity.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityRepositoriesGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.repository.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityServicesGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.service.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityShellCommandsGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.shell.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile myEntityRestControllersItemProcessor(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.restcontrollers.Class.get(entityModel, settings).doGenerateJavaFile();
    }
}
