package ru.otus.gpbu.mygena.models.myentityattribute.service;

import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import java.util.List;

public interface MyEntityAttributeService {
    List<MyEntityAttribute> getEntityAttributes(String EntityCode);
}
