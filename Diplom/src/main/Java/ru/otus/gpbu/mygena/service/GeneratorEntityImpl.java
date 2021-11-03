package ru.otus.gpbu.mygena.service;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import net.lingala.zip4j.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;
import ru.otus.gpbu.mygena.service.runtime.entity.ClassAnnotations;
import ru.otus.gpbu.mygena.service.runtime.entity.Fields;
import ru.otus.gpbu.mygena.service.runtime.entity.Header;

import javax.lang.model.element.Modifier;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
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
            path1 = Paths.get(destinationPath + "\\runtime.zip");
        }

        if (path2 == null) {
            path2 = getPath();
        }

        if (path3 == null) {
            path3 = Paths.get(destinationPath + "\\src\\main\\java");
        }



        new ZipFile(path1.toFile())
                .extractAll(path.toString());

        TypeSpec.Builder entityClassBuilder = TypeSpec.classBuilder(className);

        entityClassBuilder = Header.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder.addModifiers(Modifier.PUBLIC);
        entityClassBuilder = ClassAnnotations.get(entityClassBuilder, entityModel).generate();
        entityClassBuilder = Fields.get(entityClassBuilder, entityModel).generate();

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
