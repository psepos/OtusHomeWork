package ru.otus.gpbu.mygena.service.runtime.entity;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

        this.idField();

        return builder;
    }

    private void idField() {
        var ann = AnnotationSpec.builder(GeneratedValue.class)
                .addMember("strategy", "javax.persistence.GenerationType.IDENTITY")
                .build();

        FieldSpec fieldId = FieldSpec.builder(Long.class, "id")
                .addAnnotation(Id.class)
                .addAnnotation(ann)
                .build();

        builder.addField(fieldId);
    }
}
