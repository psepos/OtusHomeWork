package ru.otus.gpbu.mygena.service.runtime.entity;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.TypeSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

public class ClassAnnotations {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    public ClassAnnotations(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder, MyEntity entityModel){
        return new ClassAnnotations(builder, entityModel);
    }

    public TypeSpec.Builder generate() {

        this.entityAnnotation();
        this.tableAnnotation();
        this.getterAnnotation();
        this.setterAnnotation();
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

    private void getterAnnotation(){
        builder.addAnnotation(Getter.class);
    }

    private void setterAnnotation(){
        builder.addAnnotation(Setter.class);
    }

    private void noArgsConstructorAnnotation(){
        builder.addAnnotation(NoArgsConstructor.class);
    }

    private void allArgsConstructorAnnotation(){
        builder.addAnnotation(AllArgsConstructor.class);
    }

}
