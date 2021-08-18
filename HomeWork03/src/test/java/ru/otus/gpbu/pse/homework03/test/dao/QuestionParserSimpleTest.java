package ru.otus.gpbu.pse.homework03.test.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework03.dao.DaoException;
import ru.otus.gpbu.pse.homework03.dao.QuestionParser;
import ru.otus.gpbu.pse.homework03.domain.Question;

@SpringBootTest
public class QuestionParserSimpleTest {

    @Autowired
    private QuestionParser parser;

    @DisplayName("ru.otus.gpbu.pse.homework03.test.dao.getFromLineTest")
    @Test
    void getFromLineTestDelimiter() {

        boolean correctDelimiterTest = false;

        try {
            Question question = parser.getFromLine("Question;2;incorrectAnswer;correctAnswer;incorrectAnswer");
        } catch (DaoException e){
            correctDelimiterTest = true;
        }

        Assertions.assertTrue(correctDelimiterTest,"Incorrect Delimiter - 1");

        try {
            Question question = parser.getFromLine("Question,2,incorrectAnswer,correctAnswer,incorrectAnswer");
        } catch (DaoException e){
            correctDelimiterTest = false;
        }

        Assertions.assertTrue(correctDelimiterTest,"Incorrect Delimiter - 2");

    }
}