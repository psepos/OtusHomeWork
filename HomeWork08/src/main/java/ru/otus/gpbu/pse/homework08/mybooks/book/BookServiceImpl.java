package ru.otus.gpbu.pse.homework08.mybooks.book;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.author.AuthorService;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.CommentService;
import ru.otus.gpbu.pse.homework08.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework08.mybooks.genre.GenreService;
import ru.otus.gpbu.pse.homework08.mybooks.service.TriggerService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final CommentService commentService;

    private final TriggerService triggerService;

    private final GenreService genreService;

    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, CommentService commentService, TriggerService triggerService, GenreService genreService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.commentService = commentService;
        this.triggerService = triggerService;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public Optional<Book> find(Book book) {

        Optional<Book> bookOpt = bookRepository.findById(book.getId());

        bookOpt.ifPresent(this::refresh);

        return bookOpt;
    }

    @Override
    public Book save(Book book) {

        triggerService.setLastUpdate(book);

        bookRepository.save(book);
        for (Comment comment : book.getComments()) {
            comment.setBook(book);
            commentService.save(comment);
        }
        return book;
    }

    @Override
    public void delete(Book book) {
        commentService.deleteAllByBook(book);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach((book) -> book.setComments(commentService.findAllByBook(book)));
        return books;
    }

    @Override
    public Book refresh(Book book) {

        book.getGenreIds().forEach((id) -> genreService.find(Genre.get(id)).ifPresent(book::addGenre));
        book.getAuthorIds().forEach((id) -> authorService.find(Author.get(id)).ifPresent(book::addAuthor));
        book.setComments(commentService.findAllByBook(book));

        return null;
    }

    @Override
    public Book addGenre(Book book, String genreId) {
        Genre genre = Genre.get(genreId);

        Optional<Genre> genreOpt = genreService.find(genre);

        genreOpt.ifPresent(book::addGenre);

        return book;
    }
}
