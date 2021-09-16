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
        assertEquals("Sidorov", author.name());
        assertEquals(1l, author.id());
    }

    @Test
    void getGenre() {
        Genre genre = DomainObjectFactory.getGenre(1l, "Tragedy");
        assertNotNull(genre);
        assertEquals("Tragedy", genre.name());
        assertEquals(1l, genre.id());
    }

    @Test
    void getBook() {
        Author author = DomainObjectFactory.getAuthor(1l, "Sidorov");
        Genre genre = DomainObjectFactory.getGenre(2l, "Tragedy");
        Book book = DomainObjectFactory.getBook(3l, "BookName1", genre, author);

        assertNotNull(book);

        assertEquals("BookName1", book.name());
        assertEquals(3l, book.id());
        assertEquals("Tragedy", book.genre().name());
        assertEquals(2l, book.genre().id());
        assertEquals("Sidorov", book.author().name());
        assertEquals(1l, book.author().id());
    }
}
