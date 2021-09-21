package ru.otus.gpbu.pse.homework06.mybooks.author.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework06.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework06.mybooks.author.service.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorShellCommands {

    private final AuthorService service;

    public AuthorShellCommands(AuthorService service) {
        this.service = service;
    }

    @ShellMethod(value = "author-count", key = "ac")
    public Long authorCount() {
        return service.count();
    }

    @ShellMethod(value = "author-get-all", key = "aga")
    public List<Author> authorGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "author-delete-by-id <id>", key = "adbi")
    public long authorDeleteById(Long id) {
        return service.deleteById(id);
    }

    @ShellMethod(value = "author-get-by-id <id>", key = "agbi")
    public Author authorGetById(Long id) {
        return service.getById(id).get();
    }

    @ShellMethod(value = "author-insert <name>", key = "ai")
    public long authorInsert(String name) {
        return service.insert(name);
    }

    @ShellMethod(value = "author-update <id> <name>")
    public String authorUpdate(Long id, String name) {
        service.update(id, name);
        return "Ok";
    }

}
