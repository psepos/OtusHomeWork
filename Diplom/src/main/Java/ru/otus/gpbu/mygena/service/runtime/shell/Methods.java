package ru.otus.gpbu.mygena.service.runtime.shell;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.common.ReflectHelper;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;
import ru.otus.gpbu.mygena.service.runtime.Generator;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;

public class Methods implements Generator {
    private final TypeSpec.Builder builder;

    private final MyEntity entityModel;

    private String serviceName;

    public Methods(TypeSpec.Builder builder, MyEntity entityModel) {
        this.builder = builder;
        this.entityModel = entityModel;
    }

    public static Methods get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Methods(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        this.serviceName = StringHelper.getStringFirstLower(entityModel.getCode() + "Service");

        this.generateCreateNewEntityMethod();
        this.generateShowCurrentEntityMethod();
        this.generateDeleteEntityByIdMethod();
        this.generateFindByIdMethod();
        this.generateEditsMethod();
        this.generateSaveMethod();
        return this.builder;
    }

    private void generateSaveMethod() {
        String methodName = "save" + entityModel.getCode();

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode(serviceName + ".saveOrUpdate(entity);\n")
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateEditsMethod() {
        for(MyEntityAttribute attrib : entityModel.getAttributes()) {
            this.generateEditMethod(attrib);
        }
    }

    private void generateEditMethod(MyEntityAttribute attrib) {
        String methodName = "edit" + StringHelper.getStringFirstUpper(attrib.getCode());

        Type type = ReflectHelper.getType(attrib.getType());

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .addParameter(type, attrib.getCode())
                .addCode("entity.set" + StringHelper.getStringFirstUpper(attrib.getCode()) + "(" + attrib.getCode() + ");")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateFindByIdMethod() {

        String methodName = "find" + entityModel.getCode() + "ById";

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .addParameter(Long.class, "id")
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode("var entityOpt = " + serviceName + ".findById(id);\n")
                .addCode("entity = entityOpt.get();\n")
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateDeleteEntityByIdMethod() {

        String methodName = "delete" + entityModel.getCode() + "ById";

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .addParameter(Long.class, "id")
                .addCode(serviceName + ".deleteById(id);")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateShowCurrentEntityMethod() {
        String methodName = "showCurrent" + entityModel.getCode();

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateCreateNewEntityMethod() {
        String methodName = "createNew" + entityModel.getCode();

        MethodSpec createNewEntityMethod = MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ShellMethod.class)
                .returns(ClassName.get("", entityModel.getCode()))
                .addCode("entity = new " + entityModel.getCode() + "(); \n")
                .addCode("return entity;")
                .build();

        builder.addMethod(createNewEntityMethod);
    }
}
