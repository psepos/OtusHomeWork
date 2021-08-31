package ru.otus.gpbu.pse.homework04.test.sevice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework04.MyStudent.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework04.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework04.MyStudent.service.GetQuestionsServiceSimple;


import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@DisplayName("Class ru.otus.gpbu.pse.homework04.MyStudent.service")
@ExtendWith(MockitoExtension.class)
public class GetQuestionsServiceSimpleTest {
    @Mock
    private GetQuestionsDao dao;

    private GetQuestionsService service;

    @BeforeEach
    void setUp() {
        service = new GetQuestionsServiceSimple(dao);
    }

    @Test
    void getQuestions() {
        List<Question> testListQuestions = new ArrayList<>();

        Question questionTest1 = new Question("How much the fish?");
        questionTest1.addAnswer(new Answer("10"));
        questionTest1.addAnswer(new Answer("20"));

        testListQuestions.add(questionTest1);

        given(dao.getQuestions()).willReturn(testListQuestions);

        List<Question> testingList = service.getQuestions();

        assertThat(testingList).isNotNull();
        assertEquals(1, testingList.size());

        Question testingQuestion = (Question)testingList.toArray()[0];
        assertEquals("How much the fish?", testingQuestion.getQuestion());

        assertEquals(2, testingQuestion.getAnswers().size());

    }


}
