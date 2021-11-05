package ru.otus.gpbu.mygena.service.runtime;

import com.squareup.javapoet.JavaFile;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.io.IOException;

public interface GeneratorService {
    void start() throws IOException;
    JavaFile doEntityGenerate(MyEntity entityModel);
}
