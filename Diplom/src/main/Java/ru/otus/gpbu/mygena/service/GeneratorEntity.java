package ru.otus.gpbu.mygena.service;

import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface GeneratorEntity {
    void setEntity(MyEntity entityModel);
    void generate() throws IOException, URISyntaxException;
}
