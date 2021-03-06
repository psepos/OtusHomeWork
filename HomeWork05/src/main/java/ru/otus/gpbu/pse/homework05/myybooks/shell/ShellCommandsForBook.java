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

    @ShellMethod(value = "book-count", key = "bc")
    public Integer bookCount() {
        return bookService.count();
    }

    @ShellMethod(value = "book-get-all", key = "bga")
    public List<Book> bookGetAll() {
        return bookService.getAll();
    }

    @ShellMethod(value = "book-delete-by-id <id>", key = "bdbi")
    public String bookDeleteById(Long id) {
        bookService.deleteById(id);
        return "Ok";
    }

    @ShellMethod(value = "book-update <id> <name> <genre_id> <author_id>", key = "bu")
    public String bookUpdate(Long id, String name, Long genre_id, Long author_id) {
        bookService.update(id, name, genre_id, author_id);
        return "Ok";
    }

    @ShellMethod(value = "book-insert <name> <genre_id> <author_id>", key = "bi")
    public long bookInsert(String name, Long genre_id, Long author_id) {
        return bookService.insert(name, genre_id, author_id);
    }

    @ShellMethod(value = "book-get-by-id <id>", key = "bgbi")
    public Book bookGetById2(Long id) {
        return bookService.getById(id);
    }
}
