package ru.otus.gpbu.pse.homework06.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.mybooks.HomeWork06Application;
import ru.otus.gpbu.pse.homework06.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework06.mybooks.author.repository.AuthorRepository;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = HomeWork06Application.class)
public class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void contextLoads() {
        assertNotNull(authorRepository);
    }

    @Test
    @Transactional
    public void getById() {
        Optional<Author> author = authorRepository.getById(1);
        assertNotNull(author);
        assertTrue(author.isPresent());

        assertEquals("Author1", author.get().getName());

    }

    @Test
    @Transactional
    public void insert() {
        Author newAuthor = ModelsObjectFactory.getAuthor("NewAuthor");
        assertNotNull(newAuthor);
        long newId = authorRepository.insert(newAuthor);

        Optional<Author> insertedAuthor = authorRepository.getById(newId);

        assertNotNull(insertedAuthor);
        assertTrue(insertedAuthor.isPresent());
        assertEquals("NewAuthor", insertedAuthor.get().getName());
    }

    @Test
    @Transactional
    public void update() {
        Optional<Author> author = authorRepository.getById(5);

        assertNotNull(author);
        assertTrue(author.isPresent());

        author.get().setName("UpdateTestAuthor");

        authorRepository.update(author.get());

        Optional<Author> authorUpdated = authorRepository.getById(5);

        assertNotNull(authorUpdated);
        assertTrue(authorUpdated.isPresent());

        assertEquals("UpdateTestAuthor", authorUpdated.get().getName());

    }

    @Test
    @Transactional
    public void deleteById() {
        long result = authorRepository.deleteById(6);

        assertEquals(1, result);
    }

    @Test
    @Transactional
    public void getAll() {
        var allAuthors = authorRepository.getAll();

        assertNotNull(allAuthors);
        assertEquals(6, allAuthors.size());
    }

    @Test
    public void count() {
        long count = authorRepository.count();

        assertEquals(6, count);
    }
}
