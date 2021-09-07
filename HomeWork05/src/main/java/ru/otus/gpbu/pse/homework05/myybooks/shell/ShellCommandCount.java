package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.BookDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainEnum;

import java.sql.SQLException;

@ShellComponent
public class ShellCommandCount {

    private final GenreDao genreDao;
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public ShellCommandCount(GenreDao genreDao, AuthorDao authorDao, BookDao bookDao) {
        this.genreDao = genreDao;
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @ShellMethod(value = "count <Genre|Author|Book>")
    public void count(DomainEnum entity) throws SQLException {
        Integer count = 0;

        switch (entity){
            case Genre:
                count = genreDao.count();
                break;
            case Book:
                count = bookDao.count();
                break;
            case Author:
                count = authorDao.count();
                break;
        }
        System.out.println(count);
    }
}
