package ru.otus.gpbu.pse.homework05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.Shell;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Homework05ApplicationTests {

    @Autowired
    private Shell shell;

    @Test
    void contextLoads() {
        assertNotNull(shell);
    }

}