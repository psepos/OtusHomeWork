package ru.otus.gpbu.mygena.service.runtime.entity;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import javax.lang.model.element.Modifier;
import javax.persistence.Column;
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
        this.allField();
        return builder;
    }

    private void allField() {
        for (MyEntityAttribute attributeModel : entityModel.getAttributes()) {
            this.field(attributeModel);
        }
    }

    private void field(MyEntityAttribute attributeModel) {

        //TODO Расширить список типов
        switch (attributeModel.getType()) {
            case ("Long"):
                fieldLong(attributeModel);
                break;
            case ("String"):
                fieldString(attributeModel);
                break;
        }
    }

    private void fieldString(MyEntityAttribute attributeModel) {
        var ann = AnnotationSpec.builder(Column.class)
                .addMember("name", "\"" + attributeModel.getCode() + "\"")
                .build();

        FieldSpec field = FieldSpec.builder(String.class, attributeModel.getCode())
                .addModifiers(Modifier.PRIVATE)
                .addAnnotation(ann)
                .build();
        builder.addField(field);
    }

    private void fieldLong(MyEntityAttribute attributeModel) {
        var ann = AnnotationSpec.builder(Column.class)
                .addMember("name", "\"" + attributeModel.getCode() + "\"")
                .build();

        FieldSpec field = FieldSpec.builder(Long.class, attributeModel.getCode())
                .addModifiers(Modifier.PRIVATE)
                .addAnnotation(ann)
                .build();
        builder.addField(field);
    }


    private void idField() {
        var ann = AnnotationSpec.builder(GeneratedValue.class)
                .addMember("strategy", "javax.persistence.GenerationType.IDENTITY")
                .build();

        FieldSpec fieldId = FieldSpec.builder(Long.class, "id")
                .addModifiers(Modifier.PRIVATE)
                .addAnnotation(Id.class)
                .addAnnotation(ann)
                .build();

        builder.addField(fieldId);
    }
}
