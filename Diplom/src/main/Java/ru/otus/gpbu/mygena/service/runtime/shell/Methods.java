package ru.otus.gpbu.mygena.service.runtime.shell;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.Generator;

import javax.lang.model.element.Modifier;

public class Methods implements Generator {
    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    private String serviceName;

    public Methods(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static Methods get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Methods(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.serviceName = StringHelper.getStringFirstLower(entityModel.getCode() + "Service");

        this.generateCreateNewEntityMethod();
        this.generateShowCurrentEntityMethod();

        return this.builder;
    }

    private void generateShowCurrentEntityMethod() {
        String methodName = "showCurrent" + entityModel.getCode();

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateCreateNewEntityMethod() {
        String methodName = "createNew" + entityModel.getCode();

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode("entity = new " + entityModel.getCode() + "(); \n")
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }
}
