package ru.otus.gpbu.mygena.service.runtime;

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
    private final MySettingService sett;

    public PathServiceImpl(MySettingService settings) {
        this.sett = settings;
    }


    @Override
    public Path environmentTemplateFileWithPath() throws IOException, URISyntaxException {

        Path path1;

        String runtimeTemplatePath = sett.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE_PATH");

        var uri = ClassLoader.getSystemResource(runtimeTemplatePath + environmentTemplateFile()).toURI();

        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);

        path1 = fs.getPath(array[1]);
        //fs.close();

        return path1;
    }

    @Override
    public Path environmentTemplateFile() {
        return Paths.get(sett.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path runtimeEnvironmentDestinationPath() {
        return Paths.get(sett.getSetting("GENERATOR.OUTPUT_DIR"));
    }

    @Override
    public Path runtimeEnvironmentDestinationFileWithPath() {
        return Paths.get(sett.getSetting("GENERATOR.OUTPUT_DIR") + sett.getSetting("RUNTIME.ENVIRONMENT.TEMPLATE_FILE"));
    }

    @Override
    public Path runtimeEnvironmentSources() {
        return Paths.get(runtimeEnvironmentDestinationPath() + "\\src\\main\\java");
    }

    @Override
    public Path artifactFileName() {
        return Paths.get(sett.getSetting("RUNTIME.ENVIRONMENT.ARTIFACT_FILE_NAME"));
    }

    @Override
    public Path artifactPath() {
        return Paths.get(runtimeEnvironmentDestinationPath() + "\\target");
    }

    @Override
    public Path compileLog() {
        return Paths.get(sett.getSetting("RUNTIME.ENVIRONMENT.COMPILE.LOG_FILE"));
    }
}
