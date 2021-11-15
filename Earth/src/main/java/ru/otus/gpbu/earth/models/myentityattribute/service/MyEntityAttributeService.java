package ru.otus.gpbu.earth.models.myentityattribute.service;

import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttribute;

import java.util.List;

public interface MyEntityAttributeService {
    List<MyEntityAttribute> getEntityAttributes(String EntityCode);
}
