package ru.otus.gpbu.mygena.service;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.lingala.zip4j.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import javax.lang.model.element.Modifier;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@Service
public class GeneratorEntityImpl implements GeneratorEntity {

    private MyEntity entityModel;
    private Path path;
    private Path path1;
    private Path path2;
    private Path path3;

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
    public void generate() throws IOException, URISyntaxException, InterruptedException {

        String packageName = settings.getSetting("GENERATOR.PACKAGE.FOR_ENTITY");
        String destinationPath = settings.getSetting("GENERATOR.OUTPUT_DIR");
        String className = entityModel.getCode();

        if (path == null) {
            path = Paths.get(destinationPath);
        }
        if(path1 == null) {
            path1 = Paths.get(destinationPath + "\\demo.zip");
        }

        if (path2 == null) {
            path2 = getPath();
        }

        if (path3 == null) {
            path3 = Paths.get(destinationPath + "\\src\\main\\java");
        }

        Files.copy(path2, path1, StandardCopyOption.REPLACE_EXISTING);

        new ZipFile(path1.toFile())
                .extractAll(path.toString());

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

        String tableName = "USER_" + entityModel.getCode().toUpperCase(Locale.ROOT);

        AnnotationSpec ann = AnnotationSpec.builder(Table.class)
                .addMember("name", "\"" + tableName + "\"")
                        .build();

        entityClassBuilder.addAnnotation(ann);

        entityClassBuilder.addAnnotation(Getter.class);
        entityClassBuilder.addAnnotation(Setter.class);
        entityClassBuilder.addAnnotation(NoArgsConstructor.class);
        entityClassBuilder.addAnnotation(AllArgsConstructor.class);

        ann = AnnotationSpec.builder(GeneratedValue.class).addMember("strategy", "javax.persistence.GenerationType.IDENTITY").build();

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

        entityFile.writeTo(path3);

        Process process = Runtime.getRuntime().exec(
                "cmd /c start mvnw.cmd clean package",
                null,
                new File(path.toString()));
        process.waitFor();
        if (process.exitValue() != 0) {
            System.out.println("Error building runtime");
        }

    }

    private Path getPath() throws URISyntaxException, IOException {
        var uri = ClassLoader.getSystemResource("BOOT-INF/classes/runtime.zip").toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        return fs.getPath(array[1]);
    }
}
