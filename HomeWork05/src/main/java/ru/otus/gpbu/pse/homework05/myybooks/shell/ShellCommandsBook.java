package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.service.BookService;

import java.util.List;

@ShellComponent
public class ShellCommandsBook {

    private final BookService service;

    public ShellCommandsBook(BookService service) {
        this.service = service;
    }

    @ShellMethod(value = "book-count")
    public Integer bookCount() {
        return service.count();
    }

    @ShellMethod(value = "book-get-all")
    public void bookGetAll() {
        List<Book> allBooks = service.getAll();
        allBooks.forEach(book -> System.out.println(book.toString()));
    }

    @ShellMethod(value = "book-get-all2 use joins and once select")
    public void bookGetAll2() {
        List<Book> allBooks = service.getAll2();
        allBooks.forEach(book -> System.out.println(book.toString()));
    }

    @ShellMethod(value = "book-delete-by-id <id>")
    public void bookDeleteById(Long id) {
        service.deleteById(id);
    }

}
