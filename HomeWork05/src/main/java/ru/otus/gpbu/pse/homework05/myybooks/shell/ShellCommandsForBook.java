package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.service.BookService;

import java.util.List;

@ShellComponent
public class ShellCommandsForBook {

    private final BookService bookService;

    public ShellCommandsForBook(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "book-count")
    public Integer bookCount() {
        return bookService.count();
    }

    @ShellMethod(value = "book-get-all")
    public List<Book> bookGetAll() {
        return bookService.getAll();
    }

    @ShellMethod(value = "book-get-all2 use joins and once select")
    public List<Book> bookGetAll2() {
        return bookService.getAll2();
    }

    @ShellMethod(value = "book-delete-by-id <id>")
    public String bookDeleteById(Long id) {
        bookService.deleteById(id);
        return "Ok";
    }

    @ShellMethod(value = "book-update <id> <name> <genre_id> <author_id>")
    public String bookUpdate(Long id, String name, Long genre_id, Long author_id) {
        bookService.update(id, name, genre_id, author_id);
        return "Ok";
    }

    @ShellMethod(value = "book-insert <id> <name> <genre_id> <author_id>")
    public String bookInsert(Long id, String name, Long genre_id, Long author_id) {
        bookService.insert(id, name, genre_id, author_id);
        return "Ok";
    }

    @ShellMethod(value = "book-get-by-id <id>")
    public Book bookGetById(Long id) {
        return bookService.getById(id);
    }

    @ShellMethod(value = "book-get-by-id2 <id>")
    public Book bookGetById2(Long id) {
        return bookService.getById2(id);
    }
}
