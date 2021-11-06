package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.JavaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentity.MyEntityService;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import java.io.IOException;
import java.util.List;


@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private final MyEntityService myEntityService;

    @Autowired
    private final MySettingService settings;

    @Autowired
    private final PathService pathService;

    public GeneratorServiceImpl(MyEntityService myEntityService, MySettingService settings, PathService pathService) {
        this.myEntityService = myEntityService;
        this.settings = settings;
        this.pathService = pathService;
    }

    @Override
    public JavaFile doEntityGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.mygena.service.runtime.entity.Class.get(entityModel, settings).doGenerateJavaFile();
    }
}
