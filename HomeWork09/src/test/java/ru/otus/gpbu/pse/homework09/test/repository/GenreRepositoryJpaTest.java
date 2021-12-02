package ru.otus.gpbu.pse.homework09.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework09.mybooks.HomeWork09Application;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork09Application.class)
public class GenreRepositoryJpaTest {

    @Autowired
    private GenreRepository genreRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void contextLoads() {
        assertNotNull(genreRepository);
    }

    private static final long GENRE_ID_FOR_GET = 1L;
    private static final String GENRE_NAME_FOR_GET = "Genre1";
    @Test
    @Transactional
    public void getById() {
        System.out.println("getById: BEGIN");
        assertTrue(genreRepository.existsById(GENRE_ID_FOR_GET));
        Genre genre = genreRepository.getById(GENRE_ID_FOR_GET);
        assertNotNull(genre);
        assertEquals(GENRE_NAME_FOR_GET, genre.getName());
        System.out.println("getById: END");
    }

    private static final String GENRE_NAME_FOR_INSERT = "newGenre";

    @Test
    @Transactional()
    public void insert() {
        Genre genre = ModelsObjectFactory.getGenre(GENRE_NAME_FOR_INSERT);
        assertNotNull(genre);

        Genre insertedGenre = genreRepository.save(genre);
        assertNotNull(insertedGenre);
        assertEquals(GENRE_NAME_FOR_INSERT, insertedGenre.getName());

    }

    @Test
    @Transactional
    public void update() {
        Genre genre = genreRepository.getById(5L);
        assertNotNull(genre);

        genre.setName("GenreTestUpdate");
        genreRepository.save(genre);

        Genre genreAfterUpdate = genreRepository.getById(5L);
        assertNotNull(genreAfterUpdate);

        assertEquals("GenreTestUpdate", genreAfterUpdate.getName());

    }

    private static final long GENRE_ID_FOR_DELETE = 6;

    @Test
    @Transactional
    public void deleteById() {
        genreRepository.deleteById(GENRE_ID_FOR_DELETE);
        var genreAfterDelete = genreRepository.findById(GENRE_ID_FOR_DELETE);
        assertTrue(genreAfterDelete.isEmpty());
    }

    @Test
    public void getAll() {
        var allGenre = genreRepository.findAll();
        assertNotNull(allGenre);
        assertEquals(6, allGenre.size());
    }

    @Test
    public void count() {
        long count = genreRepository.count();
        assertEquals(6, count);
    }
}

