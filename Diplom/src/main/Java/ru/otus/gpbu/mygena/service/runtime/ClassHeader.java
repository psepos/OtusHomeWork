package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.TypeSpec;

import java.time.LocalDateTime;

public class ClassHeader {

    protected final TypeSpec.Builder builder;

    public ClassHeader(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public TypeSpec.Builder generate(){
        builder.addJavadoc("Runtime generator java code by pse\n");
        builder.addJavadoc("---------------Gena 1.0-----------\n");
        builder.addJavadoc("Generation time: " + LocalDateTime.now() + "\n");
        builder.addJavadoc("----------------------------------\n");
        return builder;
    }

}
