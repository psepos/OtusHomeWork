package ru.otus.gpbu.earth.service.runtime.shell;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.earth.helpers.ReflectHelper;
import ru.otus.gpbu.earth.helpers.StringHelper;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttribute;
import ru.otus.gpbu.earth.service.runtime.Generator;

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
        this.generateFindAllMethod();

        return this.builder;
    }

    private void generateFindAllMethod() {

        String methodName = "findAll" + entityModel.getCode();

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .returns(String.class)
                .addCode("var all = " + serviceName + ".findAll();\n")
                .addCode("return all.toString();")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateSaveMethod() {
        String methodName = "save" + entityModel.getCode();

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .returns(String.class)
                .addCode(serviceName + ".saveOrUpdate(entity);\n")
                .addCode("return entity.toString();")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateEditsMethod() {
        for(MyEntityAttribute attrib : entityModel.getAttributes()) {
            this.generateEditMethod(attrib);
        }
    }

    private void generateEditMethod(MyEntityAttribute attrib) {
        String methodName = "edit" + StringHelper.getStringFirstUpper(attrib.getCode()) + StringHelper.getStringFirstUpper(entityModel.getCode());

        Type type = ReflectHelper.getType(attrib.getType());

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .addParameter(type, attrib.getCode())
                .addCode("entity.set" + StringHelper.getStringFirstUpper(attrib.getCode()) + "(" + attrib.getCode() + ");")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateFindByIdMethod() {

        String methodName = "find" + entityModel.getCode() + "ById";

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .addParameter(Long.class, "id")
                .returns(String.class)
                .addCode("var entityOpt = " + serviceName + ".findById(id);\n")
                .addCode("entity = entityOpt.get();\n")
                .addCode("return entity.toString();")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateDeleteEntityByIdMethod() {

        String methodName = "delete" + entityModel.getCode() + "ById";

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .addParameter(Long.class, "id")
                .addCode(serviceName + ".deleteById(id);")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateShowCurrentEntityMethod() {
        String methodName = "showCurrent" + entityModel.getCode();

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .returns(String.class)
                .addCode("return entity.toString();")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private void generateCreateNewEntityMethod() {
        String methodName = "createNew" + entityModel.getCode();

        MethodSpec createNewEntityMethod = getMethodSpecBuilder(methodName)
                .returns(String.class)
                .addCode("entity = new " + entityModel.getCode() + "(); \n")
                .addCode("return entity.toString();")
                .build();

        builder.addMethod(createNewEntityMethod);
    }

    private MethodSpec.Builder getMethodSpecBuilder(String methodName) {

        AnnotationSpec ann = AnnotationSpec.builder(ShellMethod.class)
                .addMember("value", "\"" + methodName + "\"")
                .addMember("key", "\"" + methodName + "\"")
                .build();

        return MethodSpec
                .methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ann);
    }
}
