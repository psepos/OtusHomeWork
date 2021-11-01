package ru.otus.gpbu.mygena.models.myentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class MyEntityShell {

    @Autowired
    private MyEntityService myEntityService;

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
}
