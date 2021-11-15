package ru.otus.gpbu.earth.service.runtime.restcontrollers;

import com.squareup.javapoet.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.earth.common.StringHelper;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.service.runtime.Generator;

import javax.lang.model.element.Modifier;
import java.util.List;

public class Methods implements Generator {

    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    private ClassName entityClassName;

    public Methods(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
        entityClassName = ClassName.get("", StringHelper.getStringFirstUpper(entityModel.getCode()));
    }

    public static Methods get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Methods(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.findAll();
        this.findById();
        this.deleteById();
        this.save();
        return builder;
    }

    private void save() {
        String methodName = "save";

        ParameterizedTypeName returnType = ParameterizedTypeName.get(
                ClassName.get(ResponseEntity.class),
                entityClassName);

        String paramName = StringHelper.getStringFirstLower(entityClassName.simpleName());

        ParameterSpec param = ParameterSpec
                .builder(entityClassName, paramName)
                .addAnnotation(Validated.class)
                .addAnnotation(RequestBody.class)
                .build();

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(PostMapping.class).build())
                .returns(returnType)
                .addParameter(param)
                .addStatement("service.saveOrUpdate($N)", paramName)
                .addStatement("return ResponseEntity.ok().body($N)", paramName)
                .build();

        builder.addMethod(findByIdMethod);
    }

    private void deleteById() {
        String methodName = "deleteById";

        CodeBlock body = CodeBlock
                .builder()
                .addStatement("service.deleteById(id)")
                .addStatement("return ResponseEntity.ok().body(id)")
                .build();

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(RequestMapping.class)
                        .addMember("path", "\"/{id}\"")
                        .addMember("method", "{org.springframework.web.bind.annotation.RequestMethod.DELETE}")
                        .build())
                .addParameter(ParameterSpec
                        .builder(long.class, "id")
                        .addAnnotation(AnnotationSpec.builder(PathVariable.class).build())
                        .build())
                .returns(ParameterizedTypeName.get(
                        ClassName.get(ResponseEntity.class),
                        ClassName.get(Long.class)))
                .addCode(body)
                .build();

        builder.addMethod(findByIdMethod);

    }

    private void findById() {
        String methodName = "findById";

        CodeBlock body = CodeBlock
                .builder()
                .addStatement("java.util.Optional<$N> entity = service.findById(id)", entityClassName.simpleName())
                .beginControlFlow("if (entity.isEmpty())")
                .addStatement("return ResponseEntity.notFound().build()")
                .endControlFlow()
                .addStatement("return ResponseEntity.ok().body(entity.get())")
                .build();

        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(GetMapping.class)
                        .addMember("path", "\"/{id}\"")
                        .build())
                .addParameter(ParameterSpec
                        .builder(long.class, "id")
                        .addAnnotation(AnnotationSpec.builder(PathVariable.class).build())
                        .build())
                .returns(ParameterizedTypeName.get(
                        ClassName.get(ResponseEntity.class),
                        entityClassName))
                .addCode(body)
                .build();

        builder.addMethod(findByIdMethod);

    }

    private void findAll() {

        String methodName = "findAll";

        ParameterizedTypeName listOfEntity = ParameterizedTypeName.get(
                ClassName.get(List.class),
                entityClassName);


        MethodSpec findByIdMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(GetMapping.class)
                        .build())
                .returns(ParameterizedTypeName.get(
                        ClassName.get(ResponseEntity.class),
                        listOfEntity))
                .addCode("List<" + entityClassName.simpleName() + "> listAll = service.findAll();\n")
                .addCode("return ResponseEntity.ok().body(listAll);\n")
                .build();

        builder.addMethod(findByIdMethod);
    }
}
