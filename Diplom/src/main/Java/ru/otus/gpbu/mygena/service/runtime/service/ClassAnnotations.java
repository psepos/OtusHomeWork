package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Service;

public class ClassAnnotations {

    private final TypeSpec.Builder builder;

    public ClassAnnotations(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder) {
        return new ClassAnnotations(builder);
    }

    public TypeSpec.Builder generate() {
        this.serviceAnnotation();
        return builder;
    }

    private void serviceAnnotation() {
        builder.addAnnotation(Service.class);
    }
}
