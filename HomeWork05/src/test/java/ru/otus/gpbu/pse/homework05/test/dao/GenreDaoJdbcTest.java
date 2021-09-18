package ru.otus.gpbu.pse.homework05.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework05.Homework05Application;
import ru.otus.gpbu.pse.homework05.myybooks.repository.DoesNotExistException;
import ru.otus.gpbu.pse.homework05.myybooks.repository.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Homework05Application.class)
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.dao")
public class GenreDaoJdbcTest {
    @Autowired
    private GenreDao dao;

    @Test
    void count() {
        long count = dao.count();
        assertEquals(4, count);
    }

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

    @Test
    void deleteById() {
        dao.deleteById(1L);
        assertThrows(DoesNotExistException.class, () -> dao.getById(1L));
    }

    @Test
    void getAll() {
        List<Genre> all = dao.getAll();
        assertNotNull(all);

        assertEquals(3, all.size());

        assertEquals("Genre1", all.get(0).name());
        assertEquals("Genre2", all.get(1).name());
        assertEquals("Genre3", all.get(2).name());

    }


}
