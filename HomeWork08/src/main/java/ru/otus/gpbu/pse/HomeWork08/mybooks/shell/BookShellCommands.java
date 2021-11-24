package ru.otus.gpbu.pse.homework08.mybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.book.Book;
import ru.otus.gpbu.pse.homework08.mybooks.book.BookService;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.CommentService;
import ru.otus.gpbu.pse.homework08.mybooks.genre.Genre;

import java.util.List;
import java.util.Optional;

@ShellComponent
public class BookShellCommands {

    private final BookService bookService;
    private final CommentService commentService;

    private Book book = Book.get();

    public BookShellCommands(BookService bookService, CommentService commentService) {
        this.bookService = bookService;
        this.commentService = commentService;
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

    @ShellMethod(value = "delete-author", key = "b-delA")
    public Book deleteAuthor(String authorName) {
        book.deleteAuthor(Author.get(authorName));
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

    @ShellMethod(value = "find-all-book", key = "b-find-all")
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    @ShellMethod(value = "delete-by-id", key = "b-delete")
    public String deleteById(String id) {
        bookService.delete(Book.get(id));
        return "successfully deleted";
    }

    @ShellMethod(value = "find-by-id-book", key = "b-find-by-id")
    public Book findByIdBook(String id) {
        book = bookService.find(Book.get(id)).get();
        return book;
    }

    @ShellMethod(value = "add-comment", key = "b-addC")
    public Book addComment(String commentDesc) {
        book.addComment(Comment.get(commentDesc));
        return book;
    }

    @ShellMethod(value = "add-comment-by-id", key = "b-addCi")
    public Book addCommentById(String commentId) {
        Comment comment = Comment.get();
        comment.setId(commentId);
        Optional<Comment> commentOpt = commentService.find(comment);

        commentOpt.ifPresent(value -> book.addComment(value));

        return book;
    }
}
