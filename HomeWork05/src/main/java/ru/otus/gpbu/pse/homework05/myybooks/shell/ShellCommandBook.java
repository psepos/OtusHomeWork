package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.BookDao;

@ShellComponent
public class ShellCommandBook {

    private final BookDao bookDao;

    public ShellCommandBook(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @ShellMethod(value = "book-count")
    public Integer bookCount() {
        return bookDao.count();
    }


}
