package ru.otus.gpbu.pse.homework07.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework07.mybooks.HomeWork07Application;
import ru.otus.gpbu.pse.homework07.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework07.mybooks.author.repository.AuthorRepository;
import ru.otus.gpbu.pse.homework07.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework07.mybooks.book.repository.BookRepository;
import ru.otus.gpbu.pse.homework07.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework07.mybooks.comment.repository.CommentRepository;
import ru.otus.gpbu.pse.homework07.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework07.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework07.mybooks.genre.repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork07Application.class)
public class BookRepositoryJpaTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void contextLoads() {
        assertNotNull(bookRepository);
    }

    private static final long BOOK_ID = 1;
    private static final String BOOK_NAME = "Book1";
    private static final long BOOK_COMMENTS_COUNT = 2;
    private static final String BOOK_GENRE = "Genre1";
    private static final String BOOK_AUTHOR = "Author1";

    @Test
    @Transactional
    public void getById() {
        Optional<Book> bookOpt = bookRepository.getById(BOOK_ID);
        assertNotNull(bookOpt);
        assertTrue(bookOpt.isPresent());
        Book book = bookOpt.get();
        assertEquals(BOOK_NAME, book.getName());
        assertEquals(BOOK_COMMENTS_COUNT, book.getComments().size());
        assertEquals(BOOK_GENRE, book.getGenre().getName());
        assertEquals(BOOK_AUTHOR, book.getAuthor().getName());
    }

    private static final String NAME_FOR_NEW_BOOK = "NewBook";
    private static final long GENRE_ID_FOR_NEW_BOOK = 1;
    private static final long AUTHOR_ID_FOR_NEW_BOOK = 1;

    @Test
    @Transactional
    public void insert() {
        Genre genre = genreRepository.getById(GENRE_ID_FOR_NEW_BOOK);
        assertNotNull(genre);

        Optional<Author> author = authorRepository.getById(AUTHOR_ID_FOR_NEW_BOOK);
        assertNotNull(author);
        assertTrue(author.isPresent());

        Book book = ModelsObjectFactory.getBook(NAME_FOR_NEW_BOOK, genre, author.get());
        assertNotNull(book);

        long bookId = bookRepository.insert(book);

        Optional<Book> insertedBookOpt = bookRepository.getById(bookId);
        assertNotNull(insertedBookOpt);
        assertTrue(insertedBookOpt.isPresent());

        Book insertedBook = insertedBookOpt.get();
        assertEquals(NAME_FOR_NEW_BOOK, insertedBook.getName());
        assertEquals(GENRE_ID_FOR_NEW_BOOK, insertedBook.getGenre().getId());
        assertEquals(AUTHOR_ID_FOR_NEW_BOOK, insertedBook.getAuthor().getId());

    }

    private static final long BOOK_ID_FOR_UPDATE = 4;
    private static final long GENRE_ID_BEFORE_UPDATE = 4;
    private static final long GENRE_ID_AFTER_UPDATE = 2;
    private static final long AUTHOR_ID_BEFORE_UPDATE = 4;
    private static final long AUTHOR_ID_AFTER_UPDATE = 3;
    private static final long COMMENTS_COUNT_BEFORE_UPDATE = 2;
    private static final long COMMENTS_COUNT_AFTER_UPDATE = 3;
    private static final String NEW_COMMENT_FOR_UPDATE = "NewComment";
    private static final String BOOK_NAME_BEFORE_UPDATE = "Book4";
    private static final String BOOK_NAME_AFTER_UPDATE = "UpdatedBook4";

    @Test
    @Transactional
    public void update() {

        Optional<Book> bookOpt = bookRepository.getById(BOOK_ID_FOR_UPDATE);
        assertNotNull(bookOpt);
        assertTrue(bookOpt.isPresent());
        Book book = bookOpt.get();
        assertEquals(BOOK_NAME_BEFORE_UPDATE, book.getName());
        assertEquals(GENRE_ID_BEFORE_UPDATE,book.getGenre().getId());
        assertEquals(AUTHOR_ID_BEFORE_UPDATE,book.getAuthor().getId());
        assertEquals(COMMENTS_COUNT_BEFORE_UPDATE, book.getComments().size());
        Genre genre = genreRepository.getById(GENRE_ID_AFTER_UPDATE);
        assertNotNull(genre);

        Optional<Author> author = authorRepository.getById(AUTHOR_ID_AFTER_UPDATE);
        assertNotNull(author);
        assertTrue(author.isPresent());

        Comment newComment = ModelsObjectFactory.getComment(NEW_COMMENT_FOR_UPDATE);
        assertNotNull(newComment);

        book.setName(BOOK_NAME_AFTER_UPDATE);
        book.setGenre(genre);
        book.setAuthor(author.get());
        book.getComments().add(newComment);

        bookRepository.update(book);

        Optional<Book> updatedBookOpt = bookRepository.getById(book.getId());
        assertNotNull(updatedBookOpt);
        assertTrue(updatedBookOpt.isPresent());

        Book updatedBook = updatedBookOpt.get();

        assertEquals(BOOK_NAME_AFTER_UPDATE, updatedBook.getName());
        assertEquals(GENRE_ID_AFTER_UPDATE, updatedBook.getGenre().getId());
        assertEquals(AUTHOR_ID_AFTER_UPDATE, updatedBook.getAuthor().getId());
        assertEquals(COMMENTS_COUNT_AFTER_UPDATE, updatedBook.getComments().size());
        assertEquals(NEW_COMMENT_FOR_UPDATE, updatedBook.getComments().get(2).getDescription());

    }

    private static final long BOOK_ID_FOR_DELETE = 3;

    @Test
    @Transactional
    public void deleteById() {
        assertEquals(1, bookRepository.deleteById(BOOK_ID_FOR_DELETE));

        var result = em.createQuery("SELECT b FROM Book b WHERE b.id = :id", Book.class)
                .setParameter("id", BOOK_ID_FOR_DELETE)
                .getResultList();

        assertEquals(0, result.size());
    }

    private static final long ALL_BOOKS_COUNT = 4;

    @Test
    @Transactional
    public void getAll() {
        var allBooks = bookRepository.getAll();
        assertEquals(ALL_BOOKS_COUNT, allBooks.size());
    }

    @Test
    @Transactional
    public void count() {
        long count = bookRepository.count();
        assertEquals(ALL_BOOKS_COUNT, count);
    }
}
