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

    @ShellMethod(value = "author-count", key = "ac")
    public Integer authorCount() {
        return service.count();
    }

    @ShellMethod(value = "author-get-all", key = "aga")
    public List<Author> authorGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "author-delete-by-id <id>", key = "adbi")
    public String authorDeleteById(Long id) {
        service.deleteById(id);
        return "Ok";
    }

    @ShellMethod(value = "author-get-by-id <id>", key = "agi")
    public Author authorGetById(Long id) {
        return service.getById(id);
    }

    @ShellMethod(value = "author-insert <id> <name>", key = "ai")
    public String authorInsert(Long id, String name) {
        service.insert(id, name);
        return "Ok";
    }

    @ShellMethod(value = "author-update <id> <name>")
    public String authorUpdate(Long id, String name) {
        service.update(id, name);
        return "Ok";
    }

}
