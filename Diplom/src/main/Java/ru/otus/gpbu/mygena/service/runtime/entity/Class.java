package ru.otus.gpbu.mygena.service.runtime.entity;

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
        String packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");
        TypeSpec entityClass = doGenerateTypeSpec();

        return JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();
    }

    private TypeSpec doGenerateTypeSpec() {

        String className = entityModel.getCode();

        TypeSpec.Builder entityClassBuilder = TypeSpec.classBuilder(className);

        entityClassBuilder = Header.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder.addModifiers(Modifier.PUBLIC);
        entityClassBuilder = ClassAnnotations.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder = Fields.get(entityClassBuilder, entityModel).generate();

        return entityClassBuilder.build();
    }
}
