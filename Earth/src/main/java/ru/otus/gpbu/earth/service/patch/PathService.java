package ru.otus.gpbu.earth.service.patch;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public interface PathService {
    Path moonTemplateFileWithPath() throws IOException, URISyntaxException;
    Path moonTemplateFile();
    Path moonDestinationPath();
    Path moonDestinationFileWithPath();
    Path moonSources();
    Path moonArtifactFileName();
    Path moonArtifactPath();
    Path moonArtifactFileNameWithPath();
    Path compileLog();
    Path adminServerPath();
    Path adminServerJarFile();
    Path adminServerJarFileWithPath();
    Path adminServerTemplateJarFile() throws URISyntaxException, IOException;
}
