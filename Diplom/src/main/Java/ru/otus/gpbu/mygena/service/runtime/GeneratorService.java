package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.JavaFile;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

public interface GeneratorService {
    JavaFile doEntityGenerate(MyEntity entityModel);
}
