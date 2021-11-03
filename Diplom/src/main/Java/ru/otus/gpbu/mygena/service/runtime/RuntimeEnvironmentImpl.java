package ru.otus.gpbu.mygena.service.runtime;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RuntimeEnvironmentImpl implements RuntimeEnvironment {

    @Autowired
    private final PathService patches;

    public RuntimeEnvironmentImpl(PathService patches) {
        this.patches = patches;
    }

    @Override
    public void prepare() throws Exception {
        this.clear();
        this.copyTemplate();
        this.unzipTemplate();
        this.deleteTemplate();
    }

    @Override
    public void compile() {

    }

    @Override
    public void run() {

    }

    private void clear() {

    }

    private void copyTemplate() throws URISyntaxException, IOException {
        Path pathTemplate = getPathRuntimeEnvironmentTemplate();

    }

    private void deleteTemplate() {
    }

    private void unzipTemplate() {

    }


    private Path getPathRuntimeEnvironmentTemplate() throws URISyntaxException, IOException {
        var uri = ClassLoader.getSystemResource("BOOT-INF/classes/runtime.zip").toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        return fs.getPath(array[1]);
    }

}
