package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.ObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.service.AuthorService;
import ru.otus.gpbu.pse.homework05.myybooks.service.BookService;
import ru.otus.gpbu.pse.homework05.myybooks.service.GenreService;

import java.util.List;

@ShellComponent
public class ShellCommandsBook {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    public ShellCommandsBook(BookService bookService, GenreService genreService, AuthorService authorService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @ShellMethod(value = "book-count")
    public Integer bookCount() {
        return bookService.count();
    }

    @ShellMethod(value = "book-get-all")
    public void bookGetAll() {
        List<Book> allBooks = bookService.getAll();
        allBooks.forEach(book -> System.out.println(book.toString()));
    }

    @ShellMethod(value = "book-get-all2 use joins and once select")
    public void bookGetAll2() {
        List<Book> allBooks = bookService.getAll2();
        allBooks.forEach(book -> System.out.println(book.toString()));
    }

    @ShellMethod(value = "book-delete-by-id <id>")
    public void bookDeleteById(Long id) {
        bookService.deleteById(id);
    }

    @ShellMethod(value = "book-update <id> <name> <genre_id> <author_id>")
    public void bookUpdate(Long id, String name, Long genre_id, Long author_id) {
        bookService.update(ObjectFactory.getBook(
                id, name,
                genreService.getById(genre_id),
                authorService.getById(author_id)));
    }

    @ShellMethod(value = "book-insert <id> <name> <genre_id> <author_id>")
    public void bookInsert(Long id, String name, Long genre_id, Long author_id) {
        bookService.insert(ObjectFactory.getBook(
                id, name,
                genreService.getById(genre_id),
                authorService.getById(author_id)));
    }

}
