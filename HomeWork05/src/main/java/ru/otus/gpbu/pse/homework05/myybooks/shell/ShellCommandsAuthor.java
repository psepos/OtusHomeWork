package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.service.AuthorService;

import java.util.List;

@ShellComponent
public class ShellCommandsAuthor {

    private final AuthorService service;

    public ShellCommandsAuthor(AuthorService service) {
        this.service = service;
    }

    @ShellMethod(value = "author-count")
    public Integer authorCount() {
        return service.count();
    }

    @ShellMethod(value = "Author-get-all")
    public void AuthorGetAll() {
        List<Author> allAuthor = service.getAll();
        allAuthor.forEach(Author -> System.out.println(Author.toString()));
    }

    @ShellMethod(value = "Author-delete-by-id <id>")
    public void AuthorDeleteById(Long id) {
        service.deleteById(id);
    }

    @ShellMethod(value = "Author-get-by-id <id>")
    public String AuthorGetById(Long id) {
        return service.getById(id).toString();
    }

    @ShellMethod(value = "Author-insert <id> <name>")
    public void AuthorInsert(Long id, String name) {
        service.insert(DomainObjectFactory.getAuthor(id, name));
    }

    @ShellMethod(value = "author-update <id> <name>")
    public void authorUpdate(Long id, String name) {
        service.update(DomainObjectFactory.getAuthor(id, name));
    }

}
