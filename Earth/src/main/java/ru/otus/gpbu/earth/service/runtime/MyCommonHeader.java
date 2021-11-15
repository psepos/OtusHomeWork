package ru.otus.gpbu.earth.service.runtime;

import com.squareup.javapoet.TypeSpec;

import java.time.LocalDateTime;

public class MyCommonHeader implements Generator {

    protected final TypeSpec.Builder builder;

    public MyCommonHeader(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    @Override
    public TypeSpec.Builder doGenerate(){
        builder.addJavadoc("Runtime generator java code by pse\n");
        builder.addJavadoc("---------------Gena 1.0-----------\n");
        builder.addJavadoc("Generation time: " + LocalDateTime.now() + "\n");
        builder.addJavadoc("----------------------------------\n");
        return builder;
    }

}
