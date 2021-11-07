package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import javax.lang.model.element.Modifier;
import java.util.List;
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

        this.findAllMethod();
        this.findByIdMethod();
        this.deleteByIdMethod();
        this.saveOrUpdateMethod();
        return builder;
    }

    private void saveOrUpdateMethod() {
        String methodName = "saveOrUpdate";

        String parameterName = StringHelper.getStringFirstLower(entityModel.getCode());
        ClassName parameterType =  ClassName.get("", entityModel.getCode());

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addParameter(parameterType, parameterName)
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode(repositoryName + ".save(" + parameterName + ");\n")
                .addCode("return " + parameterName + ";")
                .build();

        builder.addMethod(findByIdMethod);
    }

    private void deleteByIdMethod() {
        String methodName = "deleteById";

        String parameterName = "id";
        ClassName parameterType =  ClassName.get(Long.class);

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addParameter(parameterType, parameterName)
                .addModifiers(Modifier.PUBLIC)
                .addCode(repositoryName + ".deleteById(id);")
                .build();

        builder.addMethod(findByIdMethod);
    }

    private void findAllMethod() {
        String methodName = "findAll";

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .returns(ParameterizedTypeName.get(
                        ClassName.get(List.class),
                        ClassName.get("", entityModel.getCode())))
                .addCode("return " + repositoryName + ".findAll();")
                .build();

        builder.addMethod(findByIdMethod);
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
