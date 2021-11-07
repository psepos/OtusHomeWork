package ru.otus.gpbu.mygena.service.runtime.repository;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.springframework.data.jpa.repository.JpaRepository;
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

    public static Class get(MyEntity entityModel, MySettingService settings){
        return new Class(entityModel, settings);
    }

    public JavaFile doGenerateJavaFile() {
        String packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_REPOSITORY");
        TypeSpec entityClass = doGenerateTypeSpec();

        return JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();
    }

    private TypeSpec doGenerateTypeSpec() {

        String packageEntityName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");

        String interfaceName = entityModel.getCode() + "Repository";

        TypeSpec.Builder repositoryBuilder = TypeSpec.interfaceBuilder(interfaceName);

        repositoryBuilder = Header.get(repositoryBuilder, entityModel).generate();
        repositoryBuilder.addModifiers(Modifier.PUBLIC);
        repositoryBuilder.addSuperinterface(
                ParameterizedTypeName.get(
                        ClassName.get(JpaRepository.class),
                        ClassName.get(packageEntityName, entityModel.getCode()),
                        ClassName.get(Long.class))
                );


        return repositoryBuilder.build();
    }
}
