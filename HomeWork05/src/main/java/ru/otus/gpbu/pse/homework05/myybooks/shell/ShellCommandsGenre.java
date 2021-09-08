package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.service.GenreService;

import java.util.List;

@ShellComponent
public class ShellCommandsGenre {

    private final GenreService service;

    public ShellCommandsGenre(GenreService service) {
        this.service = service;
    }

    @ShellMethod(value = "genre-count")
    public Integer genreCount() {
        return service.count();
    }

    @ShellMethod(value = "genre-get-all")
    public void genreGetAll() {
        List<Genre> allGenre = service.getAll();
        allGenre.forEach(genre -> System.out.println(genre.toString()));
    }

    @ShellMethod(value = "genre-delete-by-id <id>")
    public void genreDeleteById(Long id) {
        service.deleteById(id);
    }

    @ShellMethod(value = "genre-get-by-id <id>")
    public String genreGetById(Long id) {
        return service.getById(id).toString();
    }

    @ShellMethod(value = "genre-insert <id> <name>")
    public void genreInsert(Long id, String name) {
        service.insert(DomainObjectFactory.getGenre(id, name));
    }

    @ShellMethod(value = "genre-update <id> <name>")
    public void genreUpdate(Long id, String name) {
        service.update(DomainObjectFactory.getGenre(id, name));
    }
}
