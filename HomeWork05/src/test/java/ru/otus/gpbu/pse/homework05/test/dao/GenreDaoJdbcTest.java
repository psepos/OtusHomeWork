package ru.otus.gpbu.pse.homework05.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework05.Homework05Application;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Homework05Application.class)
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.dao")
public class GenreDaoJdbcTest {
    @Autowired
    private GenreDao dao;

    @Test
    void getById() {

        Genre genre = dao.getById(1L);

        assertNotNull(genre);

        assertEquals(1L, genre.id());
        assertEquals("Genre1", genre.name());

    }

    @Test
    void insert() {
        Genre genre = DomainObjectFactory.getGenre("Genre5");
        long id = dao.insert(genre);

        assertEquals(4L, genre.id());
        assertEquals(4L, id);

        Genre insertedGenre = dao.getById(id);

        assertNotNull(insertedGenre);

        assertEquals("Genre5", insertedGenre.name());
    }

    @Test
    void update() {
        Genre genre = dao.getById(2L);
        assertNotNull(genre);

        genre.name("Genre22");

        dao.update(genre);

        Genre updatedGenre = dao.getById(genre.id());

        assertNotNull(updatedGenre);

        assertEquals(genre, updatedGenre);
        assertEquals("Genre22", updatedGenre.name());
    }
}
