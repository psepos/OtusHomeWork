package ru.otus.gpbu.earth.models.myentityattribute.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.earth.models.myentityattribute.service.MyEntityAttributeService;

@ShellComponent
public class MyEntityAttributeShell {

    @Autowired
    private MyEntityAttributeService myEntityAttributeService;

    @ShellMethod(value = "get-entity-attribute-by-entity-code", key = "geabec")
    public String getEntityAttributeByEntityCode(String EntityCode) {
        return myEntityAttributeService.getEntityAttributes(EntityCode).toString();
    }

}
