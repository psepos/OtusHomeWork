package ru.otus.gpbu.earth.service.runtime.restcontrollers;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.earth.helpers.StringHelper;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.service.runtime.Generator;

import javax.lang.model.element.Modifier;

public class Constructors implements Generator {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    private final String className;

    public Constructors(TypeSpec.Builder builder, MyEntity entityModel, String className) {
        this.builder = builder;
        this.entityModel = entityModel;
        this.className = className;
    }

    public static Constructors get(TypeSpec.Builder builder, MyEntity entityModel, String className) {
        return new Constructors(builder, entityModel, className);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.constructor1();
        return builder;
    }

    private void constructor1() {
        String parameterTypeName = StringHelper.getStringFirstUpper(entityModel.getCode() + "Service");
        String parameterName = "service";

        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ClassName.get("", parameterTypeName), parameterName)
                .addCode("this.service = service;")
                .build();

        builder.addMethod(constructor);
    }
}
