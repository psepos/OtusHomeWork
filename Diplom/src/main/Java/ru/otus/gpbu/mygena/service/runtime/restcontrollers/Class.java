package ru.otus.gpbu.mygena.service.runtime.restcontrollers;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.service.MySettingService;
import ru.otus.gpbu.mygena.service.runtime.GeneratorJavaFile;

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
        String className = StringHelper.getStringFirstUpper(entityModel.getCode() + "RestController");

        TypeSpec.Builder restControllerBuilder = TypeSpec.classBuilder(className);

        restControllerBuilder = Header.get(restControllerBuilder, entityModel).doGenerate();
        restControllerBuilder.addModifiers(Modifier.PUBLIC);
        restControllerBuilder = ClassAnnotations.get(restControllerBuilder, entityModel, settings).doGenerate();
        restControllerBuilder = Fields.get(restControllerBuilder, entityModel).doGenerate();
        restControllerBuilder = Constructors.get(restControllerBuilder, entityModel,className).doGenerate();
        restControllerBuilder = Methods.get(restControllerBuilder, entityModel).doGenerate();

        return restControllerBuilder.build();
    }
}
