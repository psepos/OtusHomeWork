package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.TypeSpec;

public interface Generator {
    TypeSpec.Builder doGenerate();
}
