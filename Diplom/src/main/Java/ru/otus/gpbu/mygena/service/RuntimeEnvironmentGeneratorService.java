package ru.otus.gpbu.mygena.service;

import com.squareup.javapoet.JavaFile;
import net.lingala.zip4j.exception.ZipException;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RuntimeEnvironmentGeneratorService {
    void clearTargetDirectory() throws IOException;
    void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException;
    void unzipTemplateEnvironment() throws ZipException;
    void compileAndBuildRuntimeStep() throws InterruptedException, IOException;
    JavaFile doEntityGenerate(MyEntity entityModel);
    JavaFile doEntityRepositoriesGenerate(MyEntity entityModel);
    JavaFile doEntityServicesGenerate(MyEntity entityModel);
    JavaFile doEntityShellCommandsGenerate(MyEntity entityModel);
    JavaFile myEntityRestControllersItemProcessor(MyEntity entityModel);
}
