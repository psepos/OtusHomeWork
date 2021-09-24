package ru.otus.gpbu.pse.homework06.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.mybooks.HomeWork06Application;
import ru.otus.gpbu.pse.homework06.mybooks.author.repository.AuthorRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = HomeWork06Application.class)
public class AuthorRepositoryJpaTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void contextLoads() {
        assertNotNull(authorRepository);
    }

}
