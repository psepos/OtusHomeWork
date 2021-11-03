package ru.otus.gpbu.mygena.service.runtime;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
public class PathServiceImpl implements PathService {

    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;

    @Override
    public Path templateEnvironmentTemplateFile() throws IOException, URISyntaxException {

        if (path1 != null) {
            return path1;
        }

        var uri = ClassLoader.getSystemResource("BOOT-INF/classes/runtime.zip").toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        path1 = fs.getPath(array[1]);
        return path1;
    }

    @Override
    public Path runtimeEnvironmentDestinationPath() {

        if (path2 != null) {
            return path2;
        }

        return null;
    }

    @Override
    public Path runtimeEnvironmentDestinationJavaCode() {

        if (path3 != null) {
            return path3;
        }

        return null;
    }
}
