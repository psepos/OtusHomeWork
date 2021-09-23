package ru.otus.gpbu.pse.homework06.mybooks.book.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework06.mybooks.book.service.BookService;

import java.util.List;

@ShellComponent
public class BookShellCommands {

    private final BookService bookService;

    public BookShellCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "book-count", key = "bc")
    public long bookCount() {
        return bookService.count();
    }

    @ShellMethod(value = "book-get-all", key = "bga")
    public List<Book> bookGetAll() {
        return bookService.getAll();
    }

    @ShellMethod(value = "book-delete-by-id <id>", key = "bdbi")
    public long bookDeleteById(Long id) {
        return bookService.deleteById(id);
    }

    @ShellMethod(value = "book-update <id> <name> <genre_id> <author_id>", key = "bu")
    public long bookUpdate(Long id, String name, Long genre_id, Long author_id) {
        return bookService.update(id, name, genre_id, author_id);
    }

    @ShellMethod(value = "book-insert <name> <genre_id> <author_id>", key = "bi")
    public long bookInsert(String name, Long genre_id, Long author_id) {
        return bookService.insert(name, genre_id, author_id);
    }

    @ShellMethod(value = "book-get-by-id <id>", key = "bgbi")
    public Book bookGetById(Long bookId) {
        return bookService.getById(bookId).get();
    }

    @ShellMethod(value = "book-add-comment <id> <commentDescription>", key = "bac")
    public long bookAddComment(Long id, String commentDescription) {
        return bookService.insertComment(id, commentDescription);
    }
}
