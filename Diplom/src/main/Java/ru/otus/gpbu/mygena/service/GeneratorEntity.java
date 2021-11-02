package ru.otus.gpbu.mygena.service;

import ru.otus.gpbu.mygena.models.myentity.MyEntity;

public interface GeneratorEntity {
    void setEntity(MyEntity entityModel);
    void generate();
}
