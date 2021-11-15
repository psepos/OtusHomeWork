package ru.otus.gpbu.earth.service;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;

@Service
@Slf4j
public class MoonGeneratorServiceImpl implements MoonGeneratorService {

    @Autowired
    private final MySettingService settings;

    public MoonGeneratorServiceImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public JavaFile doEntityGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.entity.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityRepositoriesGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.repository.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityServicesGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.service.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile doEntityShellCommandsGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.shell.Class.get(entityModel, settings).doGenerateJavaFile();
    }

    @Override
    public JavaFile myEntityRestControllersItemProcessor(MyEntity entityModel) {
        return ru.otus.gpbu.earth.service.runtime.restcontrollers.Class.get(entityModel, settings).doGenerateJavaFile();
    }
}
