package ru.otus.gpbu.pse.homework06.test.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.myybooks.models.Author;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DomainObjectFactoryTest {

    @Test
    void getAuthor() {
        Author author = DomainObjectFactory.getAuthor(1L, "Sidorov");
        assertNotNull(author);
        assertEquals("Sidorov", author.name());
        assertEquals(1L, author.id());
    }

    @Test
    void getGenre() {
        Genre genre = DomainObjectFactory.getGenre(1L, "Tragedy");
        assertNotNull(genre);
        assertEquals("Tragedy", genre.name());
        assertEquals(1L, genre.id());
    }

    @Test
    void getBook() {
        Author author = DomainObjectFactory.getAuthor(1L, "Sidorov");
        Genre genre = DomainObjectFactory.getGenre(2L, "Tragedy");
        Book book = DomainObjectFactory.getBook(3L, "BookName1", genre, author);

        assertNotNull(book);

        assertEquals("BookName1", book.name());
        assertEquals(3L, book.id());
        assertEquals("Tragedy", book.genre().name());
        assertEquals(2L, book.genre().id());
        assertEquals("Sidorov", book.author().name());
        assertEquals(1L, book.author().id());
    }
}
