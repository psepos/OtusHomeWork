package ru.otus.gpbu.mygena.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MainShellCommands {

    @ShellMethod(value = "start_gen", key = "sg")
    public void startGen() {

    }
}
