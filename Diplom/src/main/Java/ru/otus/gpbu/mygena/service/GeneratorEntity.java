package ru.otus.gpbu.mygena.service;

import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.io.IOException;

public interface GeneratorEntity {
    void setEntity(MyEntity entityModel);
    void generate() throws IOException;
}
