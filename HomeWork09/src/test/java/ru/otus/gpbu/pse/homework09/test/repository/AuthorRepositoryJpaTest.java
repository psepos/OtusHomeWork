package ru.otus.gpbu.pse.homework09.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework09.mybooks.HomeWork09Application;
import ru.otus.gpbu.pse.homework09.mybooks.author.model.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.repository.AuthorRepository;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork09Application.class)
public class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    void contextLoads() {
        assertNotNull(authorRepository);
    }

    @Test
    @Transactional
    public void getById() {
        Author author = authorRepository.getById(1L);
        assertNotNull(author);

        assertEquals("Author1", author.getName());

    }

    @Test
    @Transactional
    public void insert() {
        Author newAuthor = ModelsObjectFactory.getAuthor("NewAuthor");
        assertNotNull(newAuthor);
        newAuthor = authorRepository.save(newAuthor);

        Optional<Author> insertedAuthor = Optional.of(authorRepository.getById(newAuthor.getId()));

        assertNotNull(insertedAuthor);
        assertTrue(insertedAuthor.isPresent());
        assertEquals("NewAuthor", insertedAuthor.get().getName());
    }

    private static final long AUTHOR_ID_FOR_UPDATE = 6;

    @Test
    @Transactional
    public void update() {
        Author author = authorRepository.getById(AUTHOR_ID_FOR_UPDATE);

        assertNotNull(author);

        author.setName("UpdateTestAuthor");

        authorRepository.save(author);

        Optional<Author> authorUpdated = Optional.ofNullable(em.find(Author.class, AUTHOR_ID_FOR_UPDATE));

        assertNotNull(authorUpdated);
        assertTrue(authorUpdated.isPresent());

        assertEquals("UpdateTestAuthor", authorUpdated.get().getName());

    }

    private static final long AUTHOR_ID_FOR_DELETE = 6;
    private static final long CORRECT_CODE_FOR_DELETE = 1;
    private static final long EMPTY_LIST_AFTER_DELETE = 0;

    @Test
    @Transactional
    public void deleteById() {

        authorRepository.deleteById(AUTHOR_ID_FOR_DELETE);

        var result = em.createQuery("SELECT a FROM Author a WHERE a.id = :id", Author.class)
                .setParameter("id", AUTHOR_ID_FOR_DELETE)
                .getResultList();

        assertEquals(EMPTY_LIST_AFTER_DELETE, result.size());
    }

    private static final long AUTHORS_COUNT = 6;

    @Test
    @Transactional
    public void getAll() {
        var allAuthors = authorRepository.findAll();

        assertNotNull(allAuthors);
        assertEquals(AUTHORS_COUNT, allAuthors.size());
    }

    @Test
    public void count() {
        assertEquals(AUTHORS_COUNT, authorRepository.count());
    }
}
