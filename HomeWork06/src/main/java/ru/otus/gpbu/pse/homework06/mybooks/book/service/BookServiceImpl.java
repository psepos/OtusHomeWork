package ru.otus.gpbu.pse.homework06.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework06.mybooks.author.service.AuthorService;
import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework06.mybooks.book.repository.BookRepository;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework06.mybooks.comment.service.CommentService;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework06.mybooks.genre.service.GenreService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final CommentService commentService;

    @PersistenceContext
    private final EntityManager em;

    public BookServiceImpl(BookRepository bookRepository,
                           GenreService genreService,
                           AuthorService authorService,
                           CommentService commentService,
                           EntityManager em) {
        this.bookRepository = bookRepository;
        this.genreService = genreService;
        this.authorService = authorService;
        this.commentService = commentService;
        this.em = em;
    }

    @Override
    public Optional<Book> getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    @Transactional
    public long insert(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    @Transactional
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
    @Transactional
    public long update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    @Transactional
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
    @Transactional
    public long deleteById(long id) {
        return bookRepository.delete(ModelsObjectFactory.getBook(id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    @Transactional
    public long insertComment(Book book, Comment comment) {
        book.addComment(comment);
        return bookRepository.update(book);
    }

    @Override
    @Transactional
    public long insertComment(long bookId, long commentId) {
        Optional<Book> book = bookRepository.getById(bookId);
        if (book.isEmpty()) {
            return -1;
        }
        Optional<Comment> comment = commentService.getById(commentId);
        if (comment.isEmpty()) {
            return -2;
        }
        return this.insertComment(book.get(), comment.get());
    }

    @Override
    @Transactional
    public long insertComment(long bookId, String commentDescription) {

        Optional<Book> book = bookRepository.getById(bookId);
        if (book.isEmpty()) {
            return -1;
        }

        Comment comment = ModelsObjectFactory.getComment(commentDescription);
        commentService.insert(comment);
        return this.insertComment(book.get(), comment);
    }

    @Override
    @Transactional
    public long deleteComment(Book book, Comment comment) {
        book.getComments().remove(comment);
        return bookRepository.update(book);
    }

    @Override
    @Transactional
    public long deleteComment(long bookId, long commentId) {

        Optional<Book> book = bookRepository.getById(bookId);
        if (book.isEmpty()) {
            return -1;
        }
        Optional<Comment> comment = commentService.getById(commentId);
        if (comment.isEmpty()) {
            return -2;
        }
        return this.deleteComment(book.get(), comment.get());
    }

    @Override
    public List<Comment> getComments(long bookId) {
        return em.createQuery("SELECT c FROM Comment c WHERE c.book.id = :bookId", Comment.class).setParameter("bookId", bookId).getResultList();
    }
}
