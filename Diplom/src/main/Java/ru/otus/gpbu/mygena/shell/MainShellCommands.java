package ru.otus.gpbu.mygena.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentity.MyEntityService;
import ru.otus.gpbu.mygena.service.GeneratorEntity;
import ru.otus.gpbu.mygena.service.runtime.RuntimeEnvironment;

import java.util.Optional;

@ShellComponent
public class MainShellCommands {

    @Autowired
    private MyEntityService myEntityService;

    @Autowired
    private GeneratorEntity generator;

    @Autowired
    private RuntimeEnvironment runtime;


    @ShellMethod(value = "gen", key = "g")
    public String gen(String entityCode) throws Exception {
        Optional<MyEntity> entity = myEntityService.findByCode(entityCode);

        if (entity.isEmpty()) {
            return "Entity not found";
        }
        runtime.prepare();
        generator.setEntity(entity.get());
        generator.generate();
        runtime.compile();
        return "Ok";
    }

    @ShellMethod(value = "runtime-run", key = "rr")
    public void runtimeRun() throws Exception {
        runtime.run();
    }

}
