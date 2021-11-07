package ru.otus.gpbu.mygena.service.runtime.shell;

import com.squareup.javapoet.TypeSpec;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.Generator;

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

        return this.builder;
    }
}
