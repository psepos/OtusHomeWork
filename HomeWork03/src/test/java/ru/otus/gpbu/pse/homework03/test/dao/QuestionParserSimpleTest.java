package ru.otus.gpbu.pse.homework03.test.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework03.MyStudent.dao.DaoException;
import ru.otus.gpbu.pse.homework03.MyStudent.dao.QuestionParser;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;

@SpringBootTest
public class QuestionParserSimpleTest {

    @Autowired
    private QuestionParser parser;

    @DisplayName("ru.otus.gpbu.pse.homework03.test.dao.getFromLineTest")
    @Test
    void getFromLineTest() {

        Question question = null;

        try {
            question = parser.getFromLine("Question;2;incorrectAnswer1;correctAnswer;incorrectAnswer2");
        } catch (DaoException e){
            Assertions.fail("Parse error");
        }

        if(question == null){
            Assertions.fail("null question");
        }

        Assertions.assertEquals("Question", question.getQuestion(), "Incorrect question.size");
        Assertions.assertEquals(3, question.getAnswers().size(), "Incorrect answers.size");
        Assertions.assertEquals("incorrectAnswer1", question.getAnswers().get(0).toString(), "Incorrect answer[0]. Must be 'incorrectAnswer1', but " + question.getAnswers().get(0).toString());
        Assertions.assertEquals("correctAnswer", question.getAnswers().get(1).toString(), "Incorrect answer[1]. Must be 'correctAnswer', but " + question.getAnswers().get(1).toString());
        Assertions.assertEquals("incorrectAnswer2", question.getAnswers().get(2).toString(), "Incorrect answer[2]. Must be 'incorrectAnswer2', but " + question.getAnswers().get(2).toString());
        Assertions.assertEquals("correctAnswer", question.getCorrectAnswer().toString(), "Incorrect question.getCorrectAnswer(). Must be 'correctAnswer', but " + question.getCorrectAnswer().toString());



    }
}