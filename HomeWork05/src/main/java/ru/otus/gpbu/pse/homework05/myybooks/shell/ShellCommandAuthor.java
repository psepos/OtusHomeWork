package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.ObjectFactory;

import java.util.List;

@ShellComponent
public class ShellCommandAuthor {

    private final AuthorDao authorDao;

    public ShellCommandAuthor(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @ShellMethod(value = "author-count")
    public Integer authorCount() {
        return authorDao.count();
    }

    @ShellMethod(value = "Author-get-all")
    public void AuthorGetAll() {
        List<Author> allAuthor = authorDao.getAll();
        allAuthor.forEach(Author -> System.out.println(Author.toString()));
    }

    @ShellMethod(value = "Author-delete-by-id <id>")
    public void AuthorDeleteById(Long id) {
        authorDao.deleteById(id);
    }

    @ShellMethod(value = "Author-get-by-id <id>")
    public String AuthorGetById(Long id) {
        return authorDao.getById(id).toString();
    }

    @ShellMethod(value = "Author-insert <id> <name>")
    public void AuthorInsert(Long id, String name) {
        authorDao.insert(ObjectFactory.getAuthor(id, name));
    }

    @ShellMethod(value = "author-update <id> <name>")
    public void authorUpdate(Long id, String name) {
        authorDao.update(ObjectFactory.getAuthor(id, name));
    }

}
