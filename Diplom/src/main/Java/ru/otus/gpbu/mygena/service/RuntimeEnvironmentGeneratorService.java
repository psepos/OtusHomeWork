package ru.otus.gpbu.mygena.service;

import net.lingala.zip4j.exception.ZipException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RuntimeEnvironmentGeneratorService {
    void clearTargetDirectory();
    void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException;
    void unzipTemplateEnvironment() throws ZipException;
}
