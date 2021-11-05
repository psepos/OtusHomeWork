package ru.otus.gpbu.mygena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.service.runtime.PathService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class RuntimeEnvironmentGeneratorServiceImpl implements RuntimeEnvironmentGeneratorService {

    @Autowired
    private final PathService pathService;

    public RuntimeEnvironmentGeneratorServiceImpl(PathService pathService) {
        this.pathService = pathService;
    }

    @Override
    public void clearTargetDirectory() {

    }

    @Override
    public void copyTemplateEnvironmentToTargetDirectory() throws IOException, URISyntaxException {
        Path templateFile = pathService.environmentTemplateFileWithPath();
        Path destinationFile = pathService.runtimeEnvironmentDestinationFileWithPath();
        System.out.println("templateFile = " + templateFile);
        System.out.println("destinationFile = " + destinationFile);
        Files.copy(templateFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
