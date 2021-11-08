package ru.otus.gpbu.mygena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private final MySettingService settings;

    private Path path1;

    public PathServiceImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public Path environmentTemplateFileWithPath() throws IOException, URISyntaxException {

        if (path1 == null) {
            String runtimeTemplatePath = settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE_PATH");

            var uri = ClassLoader.getSystemResource(runtimeTemplatePath + environmentTemplateFile()).toURI();

            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");
            final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);

            path1 = fs.getPath(array[1]);

        }

        return path1;
    }

    @Override
    public Path environmentTemplateFile() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path runtimeEnvironmentDestinationPath() {
        return Paths.get(settings.getSetting("GENERATOR.OUTPUT_DIR"));
    }

    @Override
    public Path runtimeEnvironmentDestinationFileWithPath() {
        return Paths.get(settings.getSetting("GENERATOR.OUTPUT_DIR") + settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path runtimeEnvironmentSources() {
        return Paths.get(runtimeEnvironmentDestinationPath() + "\\src\\main\\java");
    }

    @Override
    public Path artifactFileName() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME"));
    }

    @Override
    public Path artifactPath() {
        return Paths.get(runtimeEnvironmentDestinationPath() + "\\target\\");
    }

    @Override
    public Path compileLog() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.COMPILE.LOG_FILE"));
    }
}
