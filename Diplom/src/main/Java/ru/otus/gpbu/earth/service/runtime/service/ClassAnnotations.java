package ru.otus.gpbu.earth.service.runtime.service;

import com.squareup.javapoet.TypeSpec;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.earth.service.runtime.Generator;

public class ClassAnnotations implements Generator {

    private final TypeSpec.Builder builder;

    public ClassAnnotations(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder) {
        return new ClassAnnotations(builder);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.serviceAnnotation();
        return builder;
    }

    private void serviceAnnotation() {
        builder.addAnnotation(Service.class);
    }
}
