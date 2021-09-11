package ru.otus.gpbu.pse.homework05.test.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DomainObjectFactoryTest {

    @Test
    void getAuthor() {
        Author author = DomainObjectFactory.getAuthor(1l, "Sidorov");
        assertNotNull(author);
        assertEquals("Sidorov", author.getName());
        assertEquals(1l, author.getId());
    }

    @Test
    void getGenre() {
        Genre genre = DomainObjectFactory.getGenre(1l, "Tragedy");
        assertNotNull(genre);
        assertEquals("Tragedy", genre.getName());
        assertEquals(1l, genre.getId());
    }

    @Test
    void getBook() {
        Author author = DomainObjectFactory.getAuthor(1l, "Sidorov");
        Genre genre = DomainObjectFactory.getGenre(2l, "Tragedy");
        Book book = DomainObjectFactory.getBook(3l, "BookName1", genre, author);

        assertNotNull(book);

        assertEquals("BookName1", book.getName());
        assertEquals(3l, book.getId());
        assertEquals("Tragedy", book.getGenre().getName());
        assertEquals(2l, book.getGenre().getId());
        assertEquals("Sidorov", book.getAuthor().getName());
        assertEquals(1l, book.getAuthor().getId());
    }
}
