package ru.otus.gpbu.earth.models.myentityattribute;

public class MyEntityAttributeBuilder {
    private final MyEntityAttribute attrib = new MyEntityAttribute();

    public static MyEntityAttributeBuilder get() {
        return new MyEntityAttributeBuilder();
    }

    public MyEntityAttributeBuilder setCode(String code) {
        attrib.setCode(code);
        return this;
    }

    public MyEntityAttributeBuilder setType(String type) {
        attrib.setType(type);
        return this;
    }

    public MyEntityAttribute build() {
        return attrib;
    }
}
