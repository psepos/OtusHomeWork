package ru.otus.gpbu.mygena.service.runtime.repository;

import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.ClassHeader;


public class Header extends ClassHeader {

    private final MyEntity entityModel;

    public Header(TypeSpec.Builder builder, MyEntity entityModel) {
        super(builder);
        this.entityModel = entityModel;
    }

    public static Header get(TypeSpec.Builder builder, MyEntity entityModel){
        return new Header(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder generate(){
        super.generate();
        builder.addJavadoc("Repository for " + entityModel.getCode() + "\n");
        builder.addJavadoc("Description: " + entityModel.getDescription() + "\n");
        builder.addJavadoc("Developer: pse\n");
        builder.addJavadoc("Version: 1\n");
        return builder;
    }
}
