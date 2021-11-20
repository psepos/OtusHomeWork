package ru.otus.gpbu.pse.homework08.mybooks.book.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework08.mybooks.book.service.BookService;

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
    public long bookDeleteById(long id) {
        return bookService.deleteById(id);
    }

    @ShellMethod(value = "book-update <id> <name> <genre_id> <author_id>", key = "bu")
    public long bookUpdate(long id, String name, long genre_id, long author_id) {
        return bookService.update(id, name, genre_id, author_id);
    }

    @ShellMethod(value = "book-insert <name> <genre_id> <author_id>", key = "bi")
    public long bookInsert(String name, Long genre_id, Long author_id) {
        return bookService.insert(name, genre_id, author_id);
    }

    @ShellMethod(value = "book-get-by-id <id>", key = "bgbi")
    public Book bookGetById(long bookId) {

        var book = bookService.getById(bookId);

        if (book.isEmpty()){
            return null;
        }

        return book.get();
    }

    @ShellMethod(value = "book-add-comment <id> <commentDescription>", key = "bac")
    public long bookAddComment(long bookId, String commentDescription) {
        return bookService.insertComment(bookId, commentDescription);
    }

    @ShellMethod(value = "book-add-comment-by-id <id> <commentId>", key = "bacbi")
    public long bookAddCommentById(long bookId, long commentId) {
        return bookService.insertComment(bookId, commentId);
    }

    @ShellMethod(value = "book-delete-comment <id> <commentId>", key = "bdc")
    public long bookDeleteComment(long bookId, long commentId) {
        return bookService.deleteComment(bookId, commentId);
    }
}
