package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.service.AuthorService;

import java.util.List;

@ShellComponent
public class ShellCommandsForAuthor {

    private final AuthorService service;

    public ShellCommandsForAuthor(AuthorService service) {
        this.service = service;
    }

    @ShellMethod(value = "author-count")
    public Integer authorCount() {
        return service.count();
    }

    @ShellMethod(value = "Author-get-all")
    public List<Author> AuthorGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "Author-delete-by-id <id>")
    public String AuthorDeleteById(Long id) {
        service.deleteById(id);
        return "Ok";
    }

    @ShellMethod(value = "Author-get-by-id <id>", key = "agi")
    public Author AuthorGetById(Long id) {
        return service.getById(id);
    }

    @ShellMethod(value = "Author-insert <id> <name>")
    public String AuthorInsert(Long id, String name) {
        service.insert(id, name);
        return "Ok";
    }

    @ShellMethod(value = "author-update <id> <name>")
    public String authorUpdate(Long id, String name) {
        service.update(id, name);
        return "Ok";
    }

}
