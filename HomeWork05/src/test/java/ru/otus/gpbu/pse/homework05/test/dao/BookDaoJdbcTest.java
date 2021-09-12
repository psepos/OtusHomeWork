package ru.otus.gpbu.pse.homework05.test.dao;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework05.Homework05Application;

@SpringBootTest(classes = Homework05Application.class)
@ComponentScan("ru.otus.gpbu.pse.homework05.myybooks.dao")
public class BookDaoJdbcTest {
}
