package ru.otus.gpbu.earth.service.runtime.shell;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
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

    public static Class get(MyEntity entityModel, MySettingService settings) {
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

        String className = entityModel.getCode() + "ShellCommand";

        TypeSpec.Builder serviceBuilder = TypeSpec.classBuilder(className);

        serviceBuilder = Header.get(serviceBuilder, entityModel).doGenerate();
        serviceBuilder.addModifiers(Modifier.PUBLIC);
        serviceBuilder = ClassAnnotations.get(serviceBuilder).doGenerate();
        serviceBuilder = Fields.get(serviceBuilder, entityModel).doGenerate();
        serviceBuilder = Methods.get(serviceBuilder, entityModel).doGenerate();

        return serviceBuilder.build();
    }
}
