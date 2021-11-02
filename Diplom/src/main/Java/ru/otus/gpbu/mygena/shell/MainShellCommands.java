package ru.otus.gpbu.mygena.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentity.MyEntityService;
import ru.otus.gpbu.mygena.service.GeneratorEntity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@ShellComponent
public class MainShellCommands {

    @Autowired
    private MyEntityService myEntityService;

    @Autowired
    private GeneratorEntity generator;

    @ShellMethod(value = "gen", key = "g")
    public String gen(String entityCode) throws IOException, URISyntaxException, InterruptedException {
        Optional<MyEntity> entity = myEntityService.findByCode(entityCode);

        if (entity.isEmpty()) {
            return "Entity not found";
        }

        generator.setEntity(entity.get());
        generator.generate();

        return "Ok";
    }
}
