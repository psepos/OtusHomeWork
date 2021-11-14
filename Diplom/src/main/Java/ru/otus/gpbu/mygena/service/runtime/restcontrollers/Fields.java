package ru.otus.gpbu.mygena.service.runtime.restcontrollers;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.Generator;

import javax.lang.model.element.Modifier;

public class Fields implements Generator {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    public Fields(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static Fields get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Fields(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.entityServiceField();
        return builder;
    }

    private void entityServiceField() {

        String typeName = StringHelper.getStringFirstUpper(entityModel.getCode() + "Service");
        String fieldName = "service";

        FieldSpec field = FieldSpec.builder(ClassName.get("", typeName), fieldName)
                .addModifiers(Modifier.PRIVATE)
                .addModifiers(Modifier.FINAL)
                .addAnnotation(Autowired.class)
                .build();
        builder.addField(field);
    }
}