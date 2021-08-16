package ru.otus.gpbu.pse.homework03.test.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework03.domain.Answer;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Class ru.otus.gpbu.pse.homework01.domain.Answer")
public class AnswerTest {

    @DisplayName("Correct constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        Answer answer = new Answer("Yes");

        assertEquals("Yes", answer.get());
    }

    @DisplayName("Correct equals")
    @Test
    void shouldCorrectEquals() {
        Answer answer1 = new Answer("Test");
        Answer answer2 = new Answer("Test");

        assertEquals(answer1, answer2);
    }

    @DisplayName("Correct hashCode")
    @Test
    void shouldCorrectHashCode() {
        Answer answer1 = new Answer("Test2");
        Answer answer2 = new Answer("Test2");

        assertEquals(answer1.hashCode(), answer2.hashCode());
    }

}
