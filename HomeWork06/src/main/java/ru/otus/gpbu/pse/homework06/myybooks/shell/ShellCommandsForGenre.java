package ru.otus.gpbu.pse.homework06.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;
import ru.otus.gpbu.pse.homework06.myybooks.service.GenreService;

import java.util.List;

@ShellComponent
public class ShellCommandsForGenre {

    private final GenreService service;

    public ShellCommandsForGenre(GenreService service) {
        this.service = service;
    }

    @ShellMethod(value = "genre-count", key = "gc")
    public Integer genreCount() {
        return service.count();
    }

    @ShellMethod(value = "genre-get-all", key = "gga")
    public List<Genre> genreGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "genre-delete-by-id <id>", key = "gdbi")
    public String genreDeleteById(Long id) {
        service.deleteById(id);
        return "Ok";
    }

    @ShellMethod(value = "genre-get-by-id <id>", key = "ggbi")
    public Genre genreGetById(Long id) {
        return service.getById(id);
    }

    @ShellMethod(value = "genre-insert <name>", key = "gi")
    public long genreInsert(String name) {
        return service.insert(name);
    }

    @ShellMethod(value = "genre-update <id> <name>", key = "gu")
    public String genreUpdate(Long id, String name) {
        service.update(id, name);
        return "Ok";
    }
}
