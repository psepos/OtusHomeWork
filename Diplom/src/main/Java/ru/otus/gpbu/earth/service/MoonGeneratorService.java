package ru.otus.gpbu.earth.service;

import com.squareup.javapoet.JavaFile;
import net.lingala.zip4j.exception.ZipException;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.service.runtime.BuildFaultException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface MoonGeneratorService {
    void clearTargetDirectory() throws IOException;
    void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException;
    void unzipTemplateEnvironment() throws ZipException;
    void compileAndBuildRuntimeStep() throws InterruptedException, IOException, BuildFaultException;
    JavaFile doEntityGenerate(MyEntity entityModel);
    JavaFile doEntityRepositoriesGenerate(MyEntity entityModel);
    JavaFile doEntityServicesGenerate(MyEntity entityModel);
    JavaFile doEntityShellCommandsGenerate(MyEntity entityModel);
    JavaFile myEntityRestControllersItemProcessor(MyEntity entityModel);
}
