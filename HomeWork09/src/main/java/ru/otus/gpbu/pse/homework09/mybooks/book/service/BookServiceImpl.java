package ru.otus.gpbu.pse.homework09.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.author.model.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.service.AuthorService;
import ru.otus.gpbu.pse.homework09.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.repository.BookRepository;
import ru.otus.gpbu.pse.homework09.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.service.CommentService;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final CommentService commentService;

    public BookServiceImpl(BookRepository bookRepository,
                           GenreService genreService,
                           AuthorService authorService,
                           CommentService commentService) {
        this.bookRepository = bookRepository;
        this.genreService = genreService;
        this.authorService = authorService;
        this.commentService = commentService;
    }

    @Override
    public Optional<Book> getById(long id) {
        return Optional.of(bookRepository.getById(id));
    }

    @Override
    public long insert(Book book) {
        return bookRepository.save(book).getId();
    }

    @Override
    public long insert(String name, Long genre_id, Long author_id) {
        Optional<Genre> genre = genreService.getById(genre_id);
        if (genre.isEmpty()) {
            return -1;
        }

        Optional<Author> author = authorService.getById(author_id);
        if (author.isEmpty()) {
            return -1;
        }

        return this.insert(ModelsObjectFactory.getBook(name, genre.get(), author.get()));
    }

    @Override
    public long update(Book book) {
        return bookRepository.save(book).getId();
    }

    @Override
    public long update(Long id, String name, Long genre_id, Long author_id) {
        Optional<Genre> genre = genreService.getById(genre_id);
        Optional<Author> author = authorService.getById(author_id);

        if (genre.isEmpty()) {
            return -1;
        }
        if (author.isEmpty()) {
            return -2;
        }

        Book book = ModelsObjectFactory.getBook(id, name, genre.get(), author.get());

        return this.update(book);
    }

    @Override
    public long deleteById(long id) {
        bookRepository.deleteById(id);
        return 1;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public long insertComment(Book book, Comment comment) {
        book.addComment(comment);
        return bookRepository.save(book).getId();
    }

    @Override
    public long insertComment(long bookId, long commentId) {
        Book book = bookRepository.getById(bookId);

        Comment comment = commentService.getById(commentId);

        return this.insertComment(book, comment);
    }

    @Override
    public long insertComment(long bookId, String commentDescription) {

        Book book = bookRepository.getById(bookId);

        Comment comment = ModelsObjectFactory.getComment(commentDescription);
        commentService.insert(comment);
        return this.insertComment(book, comment);
    }

    @Override
    public long deleteComment(Book book, Comment comment) {
        book.removeComment(comment);
        bookRepository.delete(book);
        return 1;
    }

    @Override
    public long deleteComment(long bookId, long commentId) {

        Book book = bookRepository.getById(bookId);
        Comment comment = commentService.getById(commentId);

        return this.deleteComment(book, comment);
    }
}
