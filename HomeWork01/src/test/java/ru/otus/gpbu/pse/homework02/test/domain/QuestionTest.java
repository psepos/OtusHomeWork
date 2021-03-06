package ru.otus.gpbu.pse.homework02.test.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.gpbu.pse.homework02.domain.Answer;
import ru.otus.gpbu.pse.homework02.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Class ru.otus.gpbu.pse.homework01.domain.Question")
public class QuestionTest {

    @DisplayName("Correct constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        Question question = new Question("How to use video?");
        question.addAnswer(new Answer("Yes"));
        question.addAnswer(new Answer("No"));

        assertEquals("How to use video?", question.getQuestion());
        assertEquals(2, question.getAnswers().size());
    }
}
