package ru.otus.gpbu.pse.homework05.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework05.Homework05Application;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.BookDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.DoesNotExistException;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Homework05Application.class)
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.dao")
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private AuthorDao authorDao;
    
    @Test
    void getById() {
        Book book = bookDao.getById(2);

        assertNotNull(book);
        assertEquals("book2", book.name());
    }

    @Test
    void insert() {
        Genre genre = genreDao.getById(3);
        assertNotNull(genre);

        Author author = authorDao.getById(1);
        assertNotNull(author);

        Book bookForInsert = DomainObjectFactory.getBook("BookTest", genre, author);

        long id = bookDao.insert(bookForInsert);
        assertEquals(id, bookForInsert.id());

        Book bookInserted = bookDao.getById(id);

        assertEquals(bookForInsert, bookInserted);
    }

    @Test
    void update() {
        Book bookForUpdate = bookDao.getById(1);
        assertNotNull(bookForUpdate);

        bookForUpdate.name("BookTestUpdate");

        bookDao.update(bookForUpdate);

        Book bookUpdated = bookDao.getById(bookForUpdate.id());

        assertNotNull(bookUpdated);

        assertEquals(bookForUpdate, bookUpdated);

    }

    @Test
    void deleteById() {

        bookDao.deleteById(1);
        assertThrows(DoesNotExistException.class, () -> bookDao.getById(1));
    }

    @Test
    void getAll() {
        List<Book> allBooks = bookDao.getAll();
        assertNotNull(allBooks);

        assertEquals(2, allBooks.size());
    }

    @Test
    void count() {
        long count = bookDao.count();
        assertEquals(3, count);
    }
}
