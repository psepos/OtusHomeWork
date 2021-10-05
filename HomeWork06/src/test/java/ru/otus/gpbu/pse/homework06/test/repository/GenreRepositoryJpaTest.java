package ru.otus.gpbu.pse.homework06.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.mybooks.HomeWork06Application;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework06.mybooks.genre.repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork06Application.class)
public class GenreRepositoryJpaTest {

    @Autowired
    private GenreRepository genreRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void contextLoads() {
        assertNotNull(genreRepository);
    }


    @Test
    public void getById() {
        Optional<Genre> genreOptional = genreRepository.getById(1);
        assertNotNull(genreOptional);
        assertTrue(genreOptional.isPresent());
        Genre genre = genreOptional.get();

        assertEquals("Genre1", genre.getName());
    }

    @Test
    @Transactional()
    public void insert() {
        Genre newGenre = ModelsObjectFactory.getGenre("newGenre");

        assertNotNull(newGenre);
        long newId = genreRepository.insert(newGenre);

        Optional<Genre> insertedGenre = genreRepository.getById(newId);

        assertNotNull(insertedGenre);
        assertTrue(insertedGenre.isPresent());
        assertEquals("newGenre", insertedGenre.get().getName());

    }

    @Test
    @Transactional
    public void update() {
        Optional<Genre> genreOptional = genreRepository.getById(5);
        assertNotNull(genreOptional);
        assertTrue(genreOptional.isPresent());
        Genre genre = genreOptional.get();

        genre.setName("GenreTestUpdate");
        genreRepository.update(genre);

        Optional<Genre> genreOptionalAfterUpdate = genreRepository.getById(5);
        assertNotNull(genreOptionalAfterUpdate);
        assertTrue(genreOptionalAfterUpdate.isPresent());

        assertEquals("GenreTestUpdate", genreOptionalAfterUpdate.get().getName());

    }

    private static final long GENRE_ID_FOR_DELETE = 6;
    private static final long CORRECT_CODE_FOR_DELETE = 0;
    private static final long EMPTY_LIST_AFTER_DELETE = 0;

    @Test
    @Transactional
    public void delete() {
        Optional<Genre> genreOpt = genreRepository.getById(GENRE_ID_FOR_DELETE);
        assertNotNull(genreOpt);
        assertTrue(genreOpt.isPresent());
        Genre genre = genreOpt.get();

        assertEquals(CORRECT_CODE_FOR_DELETE, genreRepository.delete(genre));

        var result = em.createQuery("SELECT g FROM Genre g WHERE g.id = :id", Genre.class)
                .setParameter("id", GENRE_ID_FOR_DELETE)
                .getResultList();

        assertEquals(EMPTY_LIST_AFTER_DELETE, result.size());
    }

    @Test
    public void getAll() {
        var allGenre = genreRepository.getAll();
        assertNotNull(allGenre);
        assertEquals(6, allGenre.size());
    }

    @Test
    public void count() {
        long count = genreRepository.count();
        assertEquals(6, count);
    }
}

