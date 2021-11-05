package ru.otus.gpbu.mygena.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.models.myentity.MyEntityService;
import ru.otus.gpbu.mygena.service.runtime.GeneratorService;
import ru.otus.gpbu.mygena.service.runtime.RuntimeEnvironment;

@ShellComponent
public class MainShellCommands {

    @Autowired
    private MyEntityService myEntityService;

    @Autowired
    private GeneratorService generator;

    @Autowired
    private RuntimeEnvironment runtime;


    @ShellMethod(value = "gen", key = "g")
    public String gen() throws Exception {
        runtime.generate();
        return "Ok";
    }


    @ShellMethod(value = "run", key = "r")
    public void run() throws Exception {
        runtime.run();
    }

}
