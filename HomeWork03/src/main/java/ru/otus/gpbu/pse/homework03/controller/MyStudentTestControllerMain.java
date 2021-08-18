package ru.otus.gpbu.pse.homework03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.config.Environment;
import ru.otus.gpbu.pse.homework03.domain.Answer;
import ru.otus.gpbu.pse.homework03.domain.Question;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

import java.util.List;
import java.util.Locale;

@Component
public class MyStudentTestControllerMain implements MyStudentTestController {

    @Autowired
    private MyStudentTestContext context;

    @Override
    public void run() {

        var ui = context.getUi();

        try {

            init();
            testStart();
            displayResults();

        } catch (Exception | Error e) {
            ui.SendMessageError(e.getMessage());
        }

    }

    private void init() {

        var ui = context.getUi();
        var msgSrc = context.getMessageSource();

        ui.SendMessage(msgSrc.getMessage("strings.enter-your-name"));

        String name = ui.GetString();

        context.setStudent(new Student(name));

    }

    private void testStart() {
        for (Question question : context.getService().getQuestions()) {
            runOneStep(question);
            context.nextStep();
        }
    }

    private void displayResults() {

        var student = context.getStudent();
        var ui = context.getUi();
        var msgSrc = context.getMessageSource();
        var passingScore = context.getEnvironment().getPassingScore();
        var locale = context.getEnvironment().getLocale();

        String testResult = msgSrc.getMessage("strings.not-passed");

        if (student.getCorrectlyAnswerCount() >= passingScore) {
            testResult = msgSrc.getMessage("strings.passed");
        }

        ui.SendMessage(msgSrc.getMessage("strings.student", student.getFio()));
        ui.SendMessage( msgSrc.getMessage("strings.test-passing-score",passingScore.toString()));
        ui.SendMessage( msgSrc.getMessage("strings.total-answered",context.getStep().toString()));
        ui.SendMessage( msgSrc.getMessage("strings.correctly-answered", student.getCorrectlyAnswerCount().toString()));
        ui.SendMessage( msgSrc.getMessage("strings.incorrectly-answered", student.getIncorrectlyAnswerCount().toString()));
        ui.SendMessage( msgSrc.getMessage("strings.test-result", testResult));
    }


    private void runOneStep(Question question) {
        var ui = context.getUi();
        var locale = context.getEnvironment().getLocale();
        var messageSource = context.getMessageSource();

        displayQuestion(question);
        displayAnswers(question.getAnswers());

        ui.SendMessage( messageSource.getMessage("strings.enter-your-answer"));

        Answer humanAnswer = new Answer(ui.GetString());

        if (humanAnswer.equals(question.getCorrectAnswer())) {
            context.getStudent().increaseCorrectAnswerCount();
        } else {
            context.getStudent().increaseIncorrectlyAnswerCount();
        }
    }

    private void displayQuestion(Question question) {
        context.getUi().SendMessage(question.getQuestion());
    }

    private void displayAnswers(List<Answer> answers) {

        for (Answer answer : answers) {
            String prefix = "   ";
            context.getUi().SendMessage(prefix + answer.get());
        }
    }
}
