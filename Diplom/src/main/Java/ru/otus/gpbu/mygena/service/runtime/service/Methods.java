package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import javax.lang.model.element.Modifier;
import java.util.Optional;


public class Methods {
    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;
    private String repositoryName;

    public Methods(TypeSpec.Builder builder, MyEntity entityModel) {
        this.entityModel = entityModel;
        this.builder = builder;
    }

    public static Methods get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Methods(builder, entityModel);
    }

    public TypeSpec.Builder generate() {

        this.repositoryName = StringHelper.getStringFirstLower(entityModel.getCode() + "Repository");

        this.findByIdMethod();
        return builder;
    }

    private void findByIdMethod() {

        String methodName = "findById";

        String parameterName = "id";
        ClassName parameterType =  ClassName.get(Long.class);

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addParameter(parameterType, parameterName)
                .addModifiers(Modifier.PUBLIC)
                .returns(ParameterizedTypeName.get(
                        ClassName.get(Optional.class),
                        ClassName.get("", entityModel.getCode())))
                .addCode("return " + repositoryName + ".findById(id);")
                .build();

        builder.addMethod(findByIdMethod);
    }
}
