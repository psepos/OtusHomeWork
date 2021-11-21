package ru.otus.gpbu.pse.homework08.mybooks.genre.shell;

import org.springframework.shell.standard.ShellComponent;
import ru.otus.gpbu.pse.homework08.mybooks.genre.service.GenreService;

@ShellComponent
public class GenreShellCommands {

    private final GenreService service;

    public GenreShellCommands(GenreService service) {
        this.service = service;
    }


}
