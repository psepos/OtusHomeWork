package ru.otus.gpbu.pse.homework05.test.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework05.Homework05Application;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.DoesNotExistException;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Homework05Application.class)
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.dao")
public class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDao dao;


    @Test
    void contextLoads() {
        assertNotNull(dao);
    }

    @Test
    void getById() {
        Author author = dao.getById(1L);

        assertNotNull(author);

        assertEquals(1L, author.id());
        assertEquals("Author1", author.name());
    }

    @Test
    void getAll() {
        List<Author> all = dao.getAll();

        assertNotNull(all);
        assertEquals(4, all.size());

        assertEquals(1,all.get(0).id());
        assertEquals("Author1",all.get(0).name());

        assertEquals(2,all.get(1).id());
        assertEquals("Author2",all.get(1).name());

        assertEquals(3,all.get(2).id());
        assertEquals("Author3",all.get(2).name());

        assertEquals(4,all.get(3).id());
        assertEquals("Author4",all.get(3).name());

    }

    @Test
    void count() {
        long count = dao.count();
        assertEquals(4L, count);
    }

    @Test
    void insert() {
        Author author = DomainObjectFactory.getAuthor(0L, "Author5");
        long id = dao.insert(author);
        assertEquals(5L, author.id());
        assertEquals(5L, id);
    }

    @Test
    void deleteById() {
        dao.deleteById(5L);
        assertThrows(DoesNotExistException.class, () -> dao.getById(5L));
    }
}
