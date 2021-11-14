package ru.otus.gpbu.earth.models.myentity.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.myentity.MyEntityBuilder;
import ru.otus.gpbu.earth.models.myentity.service.MyEntityService;
import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttribute;
import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttributeBuilder;

import java.util.Optional;

@ShellComponent
public class MyEntityShell {

    @Autowired
    private MyEntityService myEntityService;

    private MyEntity entityModel = new MyEntity();
    private MyEntityAttribute attribute;

    @ShellMethod(value = "get-entity-all", key = "gea")
    public String getEntityAll() {
        return myEntityService.findAll().toString();
    }

    @ShellMethod(value = "get-entity-by-code", key = "gebc")
    public String getEntityByCode(String code) {
        Optional<MyEntity> entity = myEntityService.findByCode(code);
        if (entity.isEmpty()) {
            return "not found";
        }
        else {
            return entity.get().toString();
        }
    }

    @ShellMethod(value = "create-entity", key = "ce")
    public String createEntity(String code, String description) {
        entityModel = MyEntityBuilder.get().setCode(code).setDescription(description).build();
        return entityModel.toString();
    }

    @ShellMethod(value = "save-entity", key = "save")
    public String save() {
        myEntityService.saveOrUpdate(entityModel);
        return entityModel.toString();
    }
    @ShellMethod(value = "add-attrib", key = "aa")
    public String addAttrib(String code, String type) {
        attribute = MyEntityAttributeBuilder.get().setCode(code).setType(type).build();
        entityModel.addAttribute(attribute);
        return entityModel.toString();
    }

    @ShellMethod(value = "remove-attribute", key = "ra")
    public String removeAttribute() {
        entityModel.removeAttribute(attribute);
        return entityModel.toString();
    }

    @ShellMethod(value = "show-entity", key = "se")
    public String showEntity() {
        return entityModel.toString();
    }

    @ShellMethod(value = "show-attr", key = "sem")
    public String showAttr() {
        return attribute.toString();
    }
}
