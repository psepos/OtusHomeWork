package ru.otus.gpbu.mygena.service;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;
import ru.otus.gpbu.mygena.service.runtime.PathService;
import ru.otus.gpbu.mygena.service.runtime.entity.ClassAnnotations;
import ru.otus.gpbu.mygena.service.runtime.entity.Fields;
import ru.otus.gpbu.mygena.service.runtime.entity.Header;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.net.URISyntaxException;


@Service
public class GeneratorEntityImpl implements GeneratorEntity {

    private MyEntity entityModel;

    @Autowired
    private final MySettingService settings;

    @Autowired
    private final PathService pathService;

    public GeneratorEntityImpl(MySettingService settings, PathService pathService) {
        this.settings = settings;
        this.pathService = pathService;
    }

    @Override
    public void setEntity(MyEntity entityModel) {
        this.entityModel = entityModel;
    }

    @Override
    public void generate() throws IOException, URISyntaxException, InterruptedException {

        String packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");
        String className = entityModel.getCode();

        TypeSpec.Builder entityClassBuilder = TypeSpec.classBuilder(className);

        entityClassBuilder = Header.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder.addModifiers(Modifier.PUBLIC);
        entityClassBuilder = ClassAnnotations.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder = Fields.get(entityClassBuilder, entityModel).generate();

        TypeSpec entityClass = entityClassBuilder.build();

        JavaFile entityFile = JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();

        entityFile.writeTo(pathService.runtimeEnvironmentSources());

    }
}
