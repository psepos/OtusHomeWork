package ru.otus.gpbu.pse.homework08.mybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.author.AuthorService;

@ShellComponent
public class AuthorShellCommand {
    private Author author;

    private final AuthorService authorService;

    public AuthorShellCommand(AuthorService authorService) {
        this.authorService = authorService;
    }

}
