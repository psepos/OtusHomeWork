package ru.otus.gpbu.earth.service.runtime;

import com.squareup.javapoet.TypeSpec;

public interface Generator {
    TypeSpec.Builder doGenerate();
}
