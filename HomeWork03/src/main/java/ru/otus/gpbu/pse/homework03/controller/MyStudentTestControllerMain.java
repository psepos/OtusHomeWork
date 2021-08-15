package ru.otus.gpbu.pse.homework03.controller;

import ru.otus.gpbu.pse.homework03.domain.Answer;
import ru.otus.gpbu.pse.homework03.domain.Question;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

import java.util.List;

public class MyStudentTestControllerMain implements MyStudentTestController {

    private final AppContext context = new AppContext();

    public MyStudentTestControllerMain(GetQuestionsService service, MyStudentTestUI ui, Integer passingScore) {
        context.setService(service);
        context.setUi(ui);
        context.setPassingScore(passingScore);
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

        ui.SendMessage("Enter your name:");
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

        String testResult = "not passed";

        if (student.getCorrectlyAnswerCount() >= context.getPassingScore()) {
            testResult = "passed";
        }

        ui.SendMessage("Student: " + student.getFio());
        ui.SendMessage("Test passing score: " + context.getPassingScore());
        ui.SendMessage("Total answered: " + context.getStep() + " questions");
        ui.SendMessage("Correctly answered: " + student.getCorrectlyAnswerCount() + " questions");
        ui.SendMessage("Incorrectly answered: " + student.getIncorrectlyAnswerCount() + " questions");
        ui.SendMessage("Test result: " + testResult);
    }


    private void runOneStep(Question question) {
        var ui = context.getUi();

        displayQuestion(question);
        displayAnswers(question.getAnswers());

        ui.SendMessage("Enter your answer:");

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
