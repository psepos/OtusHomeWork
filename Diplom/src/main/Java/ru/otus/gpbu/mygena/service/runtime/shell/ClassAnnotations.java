package ru.otus.gpbu.mygena.service.runtime.shell;

import com.squareup.javapoet.TypeSpec;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.gpbu.mygena.service.runtime.Generator;

public class ClassAnnotations implements Generator {
    private final TypeSpec.Builder builder;

    public ClassAnnotations(TypeSpec.Builder builder) {
        this.builder = builder;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder) {
        return new ClassAnnotations(builder);
    }

    public TypeSpec.Builder doGenerate() {
        this.shellAnnotation();
        return builder;
    }

    private void shellAnnotation() {
        builder.addAnnotation(ShellComponent.class);
    }
}
