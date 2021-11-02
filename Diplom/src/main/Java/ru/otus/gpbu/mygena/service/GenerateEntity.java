package ru.otus.gpbu.mygena.service;

import ru.otus.gpbu.mygena.models.myentity.MyEntity;

public interface GenerateEntity {
    void setEntity(MyEntity entityModel);
    void generate();
}
