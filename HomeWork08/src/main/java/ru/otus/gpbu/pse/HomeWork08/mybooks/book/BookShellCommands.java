package ru.otus.gpbu.pse.homework08.mybooks.book;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.genre.Genre;

import java.util.List;


@ShellComponent
public class BookShellCommands {

    private final BookService bookService;
    private Book book = Book.get();

    public BookShellCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "create-new-book", key = "b-create")
    public Book createNewBook() {
        book = Book.get();
        return book;
    }

    @ShellMethod(value = "create-new-book-by-name", key = "b-createN")
    public Book createNewBook(String name) {
        book = Book.get();
        book.setName(name);
        return book;
    }

    @ShellMethod(value = "set-name-book", key = "b-setN")
    public Book setNameBook(String name) {
        book.setName(name);
        return book;
    }

    @ShellMethod(value = "add-genre", key = "b-addG")
    public Book addGenre(String genreName) {
        book.addGenre(Genre.get(genreName));
        return book;
    }

    @ShellMethod(value = "add-author", key = "b-addA")
    public Book addAuthor(String name) {
        book.addAuthor(Author.get(name));
        return book;
    }

    @ShellMethod(value = "show-book", key = "b-show")
    public Book showBook() {
        return book;
    }

    @ShellMethod(value = "save-book", key = "b-save")
    public Book saveBook() {
        return bookService.save(this.book);
    }

    @ShellMethod(value = "find-all-book", key = "b-find")
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    @ShellMethod(value = "delete-by-id", key = "b-delete")
    public String deleteById(String id) {
        bookService.deleteById(id);
        return "successfully deleted";
    }

    @ShellMethod(value = "find-by-id-book", key = "b-find-by-id")
    public Book findByIdBook(String id) {
        book = bookService.findById(id).get();
        return book;
    }

    @ShellMethod(value = "add-comment", key = "b-addC")
    public Book addComment(String commentDesc) {
        book.addComment(Comment.get(commentDesc));
        return book;
    }
}
