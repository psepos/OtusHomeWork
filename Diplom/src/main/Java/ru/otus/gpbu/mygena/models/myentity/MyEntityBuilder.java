package ru.otus.gpbu.mygena.models.myentity;

import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import java.util.Objects;

public class MyEntityBuilder {

    private final MyEntity entity = new MyEntity();

    public MyEntityBuilder setCode(String code) {
        this.entity.setCode(code);
        return this;
    }

    public MyEntityBuilder setDescription(String description) {
        this.entity.setDescription(Objects.requireNonNullElse(description, ""));
        return this;
    }

    public MyEntityBuilder addAttribute(MyEntityAttribute attribute) {
        entity.addAttribute(attribute);
        return this;
    }
}
