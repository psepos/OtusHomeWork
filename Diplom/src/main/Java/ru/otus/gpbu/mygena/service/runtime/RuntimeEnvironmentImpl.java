package ru.otus.gpbu.mygena.service.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class RuntimeEnvironmentImpl implements RuntimeEnvironment {

    @Autowired
    private final PathService pathService;

    public RuntimeEnvironmentImpl(PathService patches) {
        this.pathService = patches;
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
        Path fileTemplate = pathService.environmentTemplateFile();
        Path destinationPath = pathService.runtimeEnvironmentDestinationPath();

        Files.copy(fileTemplate, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }

    private void deleteTemplate() {
    }

    private void unzipTemplate() {

    }



}
