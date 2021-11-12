package ru.otus.gpbu.mygena.service.runtime.restcontrollers;

import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.Generator;
import ru.otus.gpbu.mygena.service.runtime.MyCommonHeader;

public class Header extends MyCommonHeader implements Generator {

    private final MyEntity entityModel;

    public Header(TypeSpec.Builder builder, MyEntity entityModel) {
        super(builder);
        this.entityModel = entityModel;
    }

    public static Header get(TypeSpec.Builder builder, MyEntity entityModel) {
        return new Header(builder, entityModel);
    }

    @Override
    public TypeSpec.Builder doGenerate() {
        super.doGenerate();
        builder.addJavadoc("RestController for " + entityModel.getCode() + "\n");
        builder.addJavadoc("Description: " + entityModel.getDescription() + "\n");
        builder.addJavadoc("Developer: pse\n");
        builder.addJavadoc("Version: 1\n");
        return builder;
    }
}
