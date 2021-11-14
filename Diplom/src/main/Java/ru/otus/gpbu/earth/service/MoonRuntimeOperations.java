package ru.otus.gpbu.earth.service;

import net.lingala.zip4j.exception.ZipException;
import ru.otus.gpbu.earth.service.runtime.BuildFaultException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface MoonRuntimeOperations {
    void clearTargetDirectory() throws IOException;
    void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException;
    void unzipTemplateEnvironment() throws ZipException;
    void compileAndBuildRuntimeStep() throws InterruptedException, IOException, BuildFaultException;

}
