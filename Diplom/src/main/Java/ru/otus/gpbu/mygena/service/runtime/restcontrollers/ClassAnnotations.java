package ru.otus.gpbu.mygena.service.runtime.restcontrollers;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.TypeSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.service.MySettingService;
import ru.otus.gpbu.mygena.service.runtime.Generator;

public class ClassAnnotations implements Generator {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    private final MySettingService settings;

    public ClassAnnotations(TypeSpec.Builder builder, MyEntity entityModel, MySettingService settings) {
        this.builder = builder;
        this.entityModel = entityModel;
        this.settings = settings;
    }

    public static ClassAnnotations get(TypeSpec.Builder builder, MyEntity entityModel, MySettingService settings) {
        return new ClassAnnotations(builder, entityModel, settings);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.restControllerAnnotation();
        this.requestMappingAnnotation();
        this.loggerAnnotation();
        return builder;
    }

    private void restControllerAnnotation() {
        builder.addAnnotation(RestController.class);
    }

    private void requestMappingAnnotation() {
        String prefix = settings.getSetting("GENERATOR.REST_API_PREFIX");
        builder.addAnnotation(AnnotationSpec.builder(RequestMapping.class)
                .addMember("value", "\"" + prefix + "/" + entityModel.getCode().toLowerCase() + "\"")
                .build());
    }

    private void loggerAnnotation() {
        builder.addAnnotation(Slf4j.class);
    }

}
