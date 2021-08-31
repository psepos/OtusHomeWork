package ru.otus.gpbu.pse.homework04.test.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Student;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Class ru.otus.gpbu.pse.homework04.domain.Student")
public class StudentTest {

    @DisplayName("Correct constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        Student student = new Student("Student");
        assertEquals("Student", student.toString());
    }

    @DisplayName("Correct constructor")
    @Test
    void shouldHaveCorrectLogic() {
        Student student = new Student("Student");
        student.increaseCorrectAnswerCount();
        assertEquals(student.getCorrectlyAnswerCount(), 1);

        student.increaseIncorrectlyAnswerCount();
        student.increaseIncorrectlyAnswerCount();
        assertEquals(student.getIncorrectlyAnswerCount(), 2);
    }

}
