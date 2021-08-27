package ru.otus.gpbu.pse.homework04.MyStudent.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(String studentName){
        return String.format("Welcome to test: %s", studentName);
    }

}
