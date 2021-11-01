package ru.otus.gpbu.mygena.models.myentityattribute;

import java.util.List;

public interface MyEntityAttributeService {
    List<MyEntityAttribute> getEntityAttributes(String EntityCode);
}
