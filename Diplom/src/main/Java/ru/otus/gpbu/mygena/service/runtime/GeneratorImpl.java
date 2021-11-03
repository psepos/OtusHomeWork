package ru.otus.gpbu.mygena.service.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentity.MyEntityService;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import java.io.IOException;
import java.util.List;


@Service
public class GeneratorImpl implements Generator {

    @Autowired
    private final MyEntityService myEntityService;

    @Autowired
    private final MySettingService settings;

    @Autowired
    private final PathService pathService;

    public GeneratorImpl(MyEntityService myEntityService, MySettingService settings, PathService pathService) {
        this.myEntityService = myEntityService;
        this.settings = settings;
        this.pathService = pathService;
    }

    @Override
    public void start() throws IOException {
        List<MyEntity> entityModels = myEntityService.findAll();

        for(MyEntity entityModel : entityModels){
            ru.otus.gpbu.mygena.service.runtime.entity.Class.get(entityModel, settings, pathService).generate();
        }
    }
}
