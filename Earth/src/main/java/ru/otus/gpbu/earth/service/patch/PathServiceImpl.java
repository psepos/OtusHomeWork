package ru.otus.gpbu.earth.service.patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;

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
    private Path path2;

    public PathServiceImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public Path moonTemplateFileWithPath() throws IOException, URISyntaxException {

        if (path1 == null) {
            String moonTemplatePath = settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE_PATH");

            var uri = ClassLoader.getSystemResource(moonTemplatePath + moonTemplateFile()).toURI();

            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");
            final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);

            path1 = fs.getPath(array[1]);

        }

        return path1;
    }

    @Override
    public Path moonTemplateFile() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path moonDestinationPath() {
        return Paths.get(settings.getSetting("GENERATOR.OUTPUT_DIR"));
    }

    @Override
    public Path moonDestinationFileWithPath() {
        return Paths.get(settings.getSetting("GENERATOR.OUTPUT_DIR") + settings.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path moonSources() {
        return Paths.get(moonDestinationPath() + "\\src\\main\\java");
    }

    @Override
    public Path moonArtifactFileName() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME"));
    }

    @Override
    public Path moonArtifactPath() {
        return Paths.get(moonDestinationPath() + "\\target\\");
    }

    @Override
    public Path moonArtifactFileNameWithPath() {
        return Paths.get(moonDestinationPath() + "\\target\\" + settings.getSetting("RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME"));
    }

    @Override
    public Path compileLog() {
        return Paths.get(settings.getSetting("RUNTIME.ENVIRONMENT.COMPILE.LOG_FILE"));
    }

    @Override
    public Path adminServerPath() {
        return Paths.get(settings.getSetting("ADMIN_SERVER.HOME_DIR"));
    }

    @Override
    public Path adminServerJarFile() {
        return Paths.get(settings.getSetting("ADMIN_SERVER.JAR_NAME"));
    }

    @Override
    public Path adminServerJarFileWithPath() {
        return Paths.get( settings.getSetting("ADMIN_SERVER.HOME_DIR") + adminServerJarFile());
    }

    @Override
    public Path adminServerTemplateJarFile() throws URISyntaxException, IOException {
        if (path2 == null) {
            String adminServerTemplatePath = settings.getSetting("ADMIN_SERVER.TEMPLATE_SOURCE");

            var uri = ClassLoader.getSystemResource(adminServerTemplatePath + adminServerJarFile()).toURI();

            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");
            final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);

            path2 = fs.getPath(array[1]);

        }

        return path2;
    }
}
