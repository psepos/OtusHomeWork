package ru.otus.gpbu.pse.homework03.controller;

import org.springframework.context.MessageSource;
import ru.otus.gpbu.pse.homework03.config.Environment;
import ru.otus.gpbu.pse.homework03.domain.Answer;
import ru.otus.gpbu.pse.homework03.domain.Question;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

import java.util.List;
import java.util.Locale;

public class MyStudentTestControllerMain implements MyStudentTestController {

    private final MyStudentTestContext context = new MyStudentTestContext();

    public MyStudentTestControllerMain(GetQuestionsService service,
                                       MyStudentTestUI ui,
                                       MessageSource messageSource,
                                       Environment environment) {
        context.setService(service);
        context.setUi(ui);
        context.setMessageSource(messageSource);
        context.setEnvironment(environment);
    }

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
        var locale = context.getEnvironment().getLocale();
        var messageSource = context.getMessageSource();

        var message = messageSource.getMessage(
                "strings.enter-your-name",
                new String[] {""},
                Locale.forLanguageTag(locale));

        ui.SendMessage(message);

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
        var messageSource = context.getMessageSource();
        var passingScore = context.getEnvironment().getPassingScore();
        var locale = context.getEnvironment().getLocale();

        String testResult = messageSource.getMessage(
                "strings.not-passed",
                new String[] {""},
                Locale.forLanguageTag(locale));

        if (student.getCorrectlyAnswerCount() >= passingScore) {
            testResult = messageSource.getMessage(
                    "strings.passed",new String[] {""},
                    Locale.forLanguageTag(locale));
        }

        ui.SendMessage(messageSource.getMessage(
                        "strings.student",
                        new String[] {student.getFio()},
                        Locale.forLanguageTag(locale)));

        ui.SendMessage( messageSource.getMessage(
                "strings.test-passing-score",
                new String[] {passingScore.toString()},
                Locale.forLanguageTag(locale)));

        ui.SendMessage( messageSource.getMessage("strings.total-answered",
                new String[] {context.getStep().toString()},
                Locale.forLanguageTag(locale)));

        ui.SendMessage( messageSource.getMessage("strings.correctly-answered",
                new String[] {student.getCorrectlyAnswerCount().toString()},
                Locale.forLanguageTag(locale)));

        ui.SendMessage( messageSource.getMessage("strings.incorrectly-answered",
                new String[] {student.getIncorrectlyAnswerCount().toString()},
                Locale.forLanguageTag(locale)));

        ui.SendMessage( messageSource.getMessage("strings.test-result",
                new String[] {testResult},
                Locale.forLanguageTag(locale)));
    }


    private void runOneStep(Question question) {
        var ui = context.getUi();
        var locale = context.getEnvironment().getLocale();
        var messageSource = context.getMessageSource();

        displayQuestion(question);
        displayAnswers(question.getAnswers());

        ui.SendMessage( messageSource.getMessage("strings.enter-your-answer",
                new String[] {},
                Locale.forLanguageTag(locale)));

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
