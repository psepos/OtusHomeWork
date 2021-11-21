package ru.otus.gpbu.pse.homework08.mybooks.author.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.author.service.AuthorService;

@ShellComponent
public class AuthorShellCommands {

    private final AuthorService service;

    public AuthorShellCommands(AuthorService service) {
        this.service = service;
    }

    @ShellMethod(value = "author-count", key = "ac")
    public int authorCount() {
        return 0;
    }

}
