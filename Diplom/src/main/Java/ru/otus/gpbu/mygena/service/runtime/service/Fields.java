package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import javax.lang.model.element.Modifier;

public class Fields {
    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    public Fields(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static Fields get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Fields(builder, entityModel);
    }

    public TypeSpec.Builder generate() {

        this.repositoryField();
        return builder;
    }

    private void repositoryField() {

        String fieldName = StringHelper.getStringFirstLower(entityModel.getCode() + "Repository");
        String typeName = entityModel.getCode() + "Repository";

        FieldSpec field = FieldSpec.builder(ClassName.get("", typeName), fieldName)
                .addModifiers(Modifier.PRIVATE)
                .addAnnotation(Autowired.class)
                .build();
        builder.addField(field);
    }

}
