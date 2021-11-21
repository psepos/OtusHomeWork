package ru.otus.gpbu.pse.homework08.mybooks.book.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework08.mybooks.book.service.BookService;

import java.util.List;


@ShellComponent
public class BookShellCommands {

    private final BookService bookService;
    private Book book = Book.get();

    public BookShellCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "create-new-book", key = "crBook")
    public Book createNewBook() {
        book = Book.get();
        return book;
    }

    @ShellMethod(value = "create-new-book-by-name", key = "crBookN")
    public Book createNewBook(String name) {
        book = Book.get();
        book.setName(name);
        return book;
    }

    @ShellMethod(value = "show-book", key = "showb")
    public Book showBook() {
        return book;
    }

    @ShellMethod(value = "insert-book", key = "ib")
    public Book insertBook() {
        return bookService.insert(this.book);
    }

    @ShellMethod(value = "find-all-book", key = "fab")
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    @ShellMethod(value = "find-by-id-book", key = "fbib")
    public Book findByIdBook(String id) {
        book = bookService.getById(id).get();
        return book;
    }
}
