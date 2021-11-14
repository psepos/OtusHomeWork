package ru.otus.gpbu.earth.service.runtime.repository;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;
import ru.otus.gpbu.earth.service.runtime.GeneratorJavaFile;

import javax.lang.model.element.Modifier;

public class Class implements GeneratorJavaFile {

    private final MyEntity entityModel;

    private final MySettingService settings;

    public Class(MyEntity entityModel, MySettingService settings) {
        this.entityModel = entityModel;
        this.settings = settings;
    }

    public static Class get(MyEntity entityModel, MySettingService settings){
        return new Class(entityModel, settings);
    }

    @Override
    public JavaFile doGenerateJavaFile() {

        TypeSpec entityClass = doGenerateTypeSpec();

        String packageName = settings.getSetting("GENERATOR.PACKAGE.ROOT_NAME") + "." + entityModel.getCode().toLowerCase();

        return JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();
    }

    private TypeSpec doGenerateTypeSpec() {

        String interfaceName = entityModel.getCode() + "Repository";

        TypeSpec.Builder repositoryBuilder = TypeSpec.interfaceBuilder(interfaceName);

        repositoryBuilder = Header.get(repositoryBuilder, entityModel).doGenerate();
        repositoryBuilder.addModifiers(Modifier.PUBLIC);
        repositoryBuilder.addSuperinterface(
                ParameterizedTypeName.get(
                        ClassName.get(JpaRepository.class),
                        ClassName.get("", entityModel.getCode()),
                        ClassName.get(Long.class))
                );


        return repositoryBuilder.build();
    }
}
