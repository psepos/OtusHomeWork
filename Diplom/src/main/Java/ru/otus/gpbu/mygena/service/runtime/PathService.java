package ru.otus.gpbu.mygena.service.runtime;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public interface PathService {
    Path templateEnvironmentTemplateFile() throws IOException, URISyntaxException;
    Path runtimeEnvironmentDestinationPath();
    Path runtimeEnvironmentDestinationJavaCode();
}
