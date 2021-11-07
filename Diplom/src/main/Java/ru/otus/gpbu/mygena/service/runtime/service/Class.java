package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import javax.lang.model.element.Modifier;

public class Class {
    private final MyEntity entityModel;

    private final MySettingService settings;

    public Class(MyEntity entityModel, MySettingService settings) {
        this.entityModel = entityModel;
        this.settings = settings;
    }

    public static Class get(MyEntity entityModel, MySettingService settings) {
        return new Class(entityModel, settings);
    }

    public JavaFile doGenerateJavaFile() {

        TypeSpec entityClass = doGenerateTypeSpec();

        String packageName = settings.getSetting("GENERATOR.PACKAGE.ROOT_NAME") + "." + entityModel.getCode().toLowerCase();

        return JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();
    }

    private TypeSpec doGenerateTypeSpec() {

        String className = entityModel.getCode() + "Service";

        TypeSpec.Builder serviceBuilder = TypeSpec.classBuilder(className);

        serviceBuilder = Header.get(serviceBuilder, entityModel).generate();
        serviceBuilder.addModifiers(Modifier.PUBLIC);
        serviceBuilder = ClassAnnotations.get(serviceBuilder).generate();
        serviceBuilder = Fields.get(serviceBuilder, entityModel).generate();
        serviceBuilder = Methods.get(serviceBuilder, entityModel).generate();

        return serviceBuilder.build();
    }

}
