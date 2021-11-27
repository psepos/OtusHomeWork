package ru.otus.gpbu.pse.homework09.mybooks.genre.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework09.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreService;

import java.util.List;

@ShellComponent
public class GenreShellCommands {

    private final GenreService service;

    public GenreShellCommands(GenreService service) {
        this.service = service;
    }

    @ShellMethod(value = "genre-count", key = "gc")
    public long genreCount() {
        return service.count();
    }

    @ShellMethod(value = "genre-get-all", key = "gga")
    public List<Genre> genreGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "genre-delete-by-id <id>", key = "gdbi")
    public String genreDeleteById(Long id) {
        service.deleteById(id);
        return "OK";
    }

    @ShellMethod(value = "genre-get-by-id <id>", key = "ggbi")
    public Genre genreGetById(Long id) {
        return service.getById(id).get();
    }

    @ShellMethod(value = "genre-insert <name>", key = "gi")
    public Genre genreInsert(String name) {
        return service.insert(name);
    }

    @ShellMethod(value = "genre-update <id> <name>", key = "gu")
    public Genre genreUpdate(Long id, String name) {
        return service.update(id, name);
    }
}
