package ru.otus.gpbu.mygena.service;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.h2.store.fs.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import javax.lang.model.element.Modifier;
import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Locale;


@Service
public class GeneratorEntityImpl implements GeneratorEntity {

    private MyEntity entityModel;

    @Autowired
    private final MySettingService settings;

    public GeneratorEntityImpl(MySettingService settings) {
        this.settings = settings;
    }

    @Override
    public void setEntity(MyEntity entityModel) {
        this.entityModel = entityModel;
    }

    @Override
    public void generate() throws IOException {

        String packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");
        String destinationPath = settings.getSetting("GENERATOR.OUTPUT_DIR");
        String className = entityModel.getCode();

        Path path = Paths.get(destinationPath);

        var entityClassBuilder = TypeSpec
                .classBuilder(className)
                .addModifiers(Modifier.PUBLIC);

        entityClassBuilder.addJavadoc("Runtime generator java code by pse\n");
        entityClassBuilder.addJavadoc("---------------Gena 1.0-----------\n");
        entityClassBuilder.addJavadoc("Description: " + entityModel.getDescription() + "\n");
        entityClassBuilder.addJavadoc("Developer: pse\n");
        entityClassBuilder.addJavadoc("Version: 1\n");
        entityClassBuilder.addJavadoc("DateTime: " + LocalDateTime.now() + "\n");
        entityClassBuilder.addJavadoc("----------------------------------\n");

        entityClassBuilder.addAnnotation(Entity.class);

        AnnotationSpec ann = AnnotationSpec.builder(Table.class)
                .addMember("name", "USER_" + entityModel.getCode().toUpperCase(Locale.ROOT))
                        .build();

        entityClassBuilder.addAnnotation(ann);

        entityClassBuilder.addAnnotation(Getter.class);
        entityClassBuilder.addAnnotation(Setter.class);
        entityClassBuilder.addAnnotation(NoArgsConstructor.class);
        entityClassBuilder.addAnnotation(AllArgsConstructor.class);

        ann = AnnotationSpec.builder(GeneratedValue.class).addMember("strategy", "GenerationType.IDENTITY").build();

        FieldSpec fieldId = FieldSpec.builder(Long.class, "id")
                .addAnnotation(Id.class)
                .addAnnotation(ann)
                .build();

        entityClassBuilder.addField(fieldId);

        TypeSpec entityClass = entityClassBuilder.build();

        JavaFile entityFile = JavaFile
                .builder(packageName, entityClass)
                .indent("    ")
                .build();

        entityFile.writeTo(path);

    }
}
