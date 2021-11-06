package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.JavaFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;


@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private final MySettingService settings;

    public GeneratorServiceImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public JavaFile doEntityGenerate(MyEntity entityModel) {
        return ru.otus.gpbu.mygena.service.runtime.entity.Class.get(entityModel, settings).doGenerateJavaFile();
    }
}
