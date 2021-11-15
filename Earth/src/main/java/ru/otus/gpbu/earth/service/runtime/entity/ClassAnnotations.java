package ru.otus.gpbu.earth.service.runtime.entity;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.TypeSpec;
import lombok.*;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.service.runtime.Generator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

public class ClassAnnotations implements Generator  {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    public ClassAnnotations(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder, MyEntity entityModel){
        return new ClassAnnotations(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {

        this.entityAnnotation();
        this.tableAnnotation();
        this.dataAnnotation();
        this.noArgsConstructorAnnotation();
        this.allArgsConstructorAnnotation();

        return builder;
    }

    private void entityAnnotation() {
        builder.addAnnotation(Entity.class);
    }

    private void tableAnnotation() {
        String tableName = "USER_" + entityModel.getCode().toUpperCase(Locale.ROOT);
        AnnotationSpec ann = AnnotationSpec.builder(Table.class)
                .addMember("name", "\"" + tableName + "\"")
                .build();
        builder.addAnnotation(ann);
    }

    private void dataAnnotation(){
        builder.addAnnotation(Data.class);
    }

    private void noArgsConstructorAnnotation(){
        builder.addAnnotation(NoArgsConstructor.class);
    }

    private void allArgsConstructorAnnotation(){
        builder.addAnnotation(AllArgsConstructor.class);
    }

}
