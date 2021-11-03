package ru.otus.gpbu.mygena.service.runtime;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public interface PathService {
    Path environmentTemplateFileWithPath() throws IOException, URISyntaxException;
    Path environmentTemplateFile();
    Path runtimeEnvironmentDestinationPath();
    Path runtimeEnvironmentDestinationFileWithPath();
    Path runtimeEnvironmentSources();
    Path artifactFileName();
    Path artifactPath();
}
