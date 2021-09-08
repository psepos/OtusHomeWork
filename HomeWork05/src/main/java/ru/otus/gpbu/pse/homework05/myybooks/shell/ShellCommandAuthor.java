package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;

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
}
