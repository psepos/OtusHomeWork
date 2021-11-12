package ru.otus.gpbu.mygena.service.runtime.service;

import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.MyCommonHeader;
import ru.otus.gpbu.mygena.service.runtime.Generator;

public class Header extends MyCommonHeader implements Generator {

    private final MyEntity entityModel;

    public Header(TypeSpec.Builder builder, MyEntity entityModel) {
        super(builder);
        this.entityModel = entityModel;
    }

    public static Header get(TypeSpec.Builder builder, MyEntity entityModel){
        return new Header(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate(){
        super.doGenerate();
        builder.addJavadoc("Service for " + entityModel.getCode() + "\n");
        builder.addJavadoc("Description: " + entityModel.getDescription() + "\n");
        builder.addJavadoc("Developer: pse\n");
        builder.addJavadoc("Version: 1\n");
        return builder;
    }

}
