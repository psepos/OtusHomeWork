package ru.otus.gpbu.mygena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

@Service
public class GeneratorEntityImpl implements GeneratorEntity {

    private MyEntity entityModel;
    private String packageName;

    @Autowired
    private final MySettingService settings;

    public GeneratorEntityImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public void setEntity(MyEntity entityModel) {
        this.entityModel = entityModel;
    }

    @Override
    public void generate() {

        packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");


    }
}
