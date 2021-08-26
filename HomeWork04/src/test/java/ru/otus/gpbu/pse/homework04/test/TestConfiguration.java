package ru.otus.gpbu.pse.homework04.test;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework04.MyStudent.dao.QuestionParser;
import ru.otus.gpbu.pse.homework04.MyStudent.dao.QuestionParserSimple;

@ComponentScan("ru.otus.gpbu.pse.homework03.test")
@SpringBootConfiguration
public class TestConfiguration {

    @Bean
    QuestionParser questionParser(){
        return new QuestionParserSimple();
    }
}
