package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.service.GenreService;

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

    @ShellMethod(value = "genre-insert <id> <name>", key = "gi")
    public String genreInsert(Long id, String name) {
        service.insert(id, name);
        return "Ok";
    }

    @ShellMethod(value = "genre-update <id> <name>", key = "gu")
    public String genreUpdate(Long id, String name) {
        service.update(id, name);
        return "Ok";
    }
}
