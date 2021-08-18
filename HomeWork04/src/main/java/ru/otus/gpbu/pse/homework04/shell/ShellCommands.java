package ru.otus.gpbu.pse.homework04.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(String studentName){
        return String.format("Welcome to test: %s", studentName);
    }

    private Availability isPublishEventCommandAvailable() {
        //return userName == null? Availability.unavailable("Сначала залогиньтесь"): Availability.available();
        return Availability.available();
    }
}
