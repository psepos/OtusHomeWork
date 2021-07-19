package ru.otus.gpbu.pse.homework01.test.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.gpbu.pse.homework01.domain.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class Answer")
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

        assertEquals(true, answer1.equals(answer2));
    }

    @DisplayName("Correct hashCode")
    @Test
    void shouldCorrectHashCode() {
        Answer answer1 = new Answer("Test2");
        Answer answer2 = new Answer("Test2");

        assertEquals(true, answer1.hashCode() == answer2.hashCode());
    }

}
