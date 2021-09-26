package ru.otus.gpbu.pse.homework06.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.mybooks.HomeWork06Application;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework06.mybooks.genre.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = HomeWork06Application.class)
public class GenreRepositoryJpaTest {

    @Autowired
    private GenreRepository genreRepository;

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

    @Test
    @Transactional
    public void deleteById() {
        Optional<Genre> genreOptional = genreRepository.getById(6);
        assertNotNull(genreOptional);
        assertTrue(genreOptional.isPresent());

        long result = genreRepository.deleteById(genreOptional.get().getId());

        assertEquals(1, result);

        Optional<Genre> genreDeleted = genreRepository.getById(6);
        assertNotNull(genreDeleted);
        System.out.println(genreDeleted.get());

    }

    @Test
    public void getAll() {
        var allGenre = genreRepository.getAll();
        assertNotNull(allGenre);
        System.out.println(allGenre);
        assertEquals(6, allGenre.size());
    }

    @Test
    public void count() {
        long count = genreRepository.count();
        assertEquals(6, count);
    }
}

