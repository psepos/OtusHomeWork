package ru.otus.gpbu.mygena.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RuntimeEnvironmentGeneratorService {
    void clearTargetDirectory();
    void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException;
}
