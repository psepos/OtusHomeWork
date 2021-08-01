package ru.otus.gpbu.pse.homework02.controller;

import ru.otus.gpbu.pse.homework02.domain.Answer;
import ru.otus.gpbu.pse.homework02.domain.Question;
import ru.otus.gpbu.pse.homework02.domain.Student;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

import java.util.List;

public class MyQuestionControllerMain implements MyQuestionController {

    private final ControllerContext context = new ControllerContext();

    public MyQuestionControllerMain(GetQuestionsService service, MyQuestionsUI ui, String numberOfCorrectAnswersToEnd) {
        context.setService(service);
        context.setUi(ui);
        context.setNumberOfCorrectAnswersToEnd(Integer.parseInt(numberOfCorrectAnswersToEnd));
    }

    @Override
    public void run() {
        var ui = context.getUi();
        var student = context.getStudent();

        try {

            ui.SendMessage("Homework 02");

            init();

            for (Question question : context.getQuestions()) {

                processOneStep(question);

                context.increaseStep();

                if (student.getCorrectlyAnswerCount() == context.getNumberOfCorrectAnswersToEnd() - 1) {
                    break;
                }
            }

            ui.SendMessage(student.getFio() + " have total answered " + context.getStep() + " questions");
            ui.SendMessage(student.getFio() + " correctly answered " + student.getCorrectlyAnswerCount() + " questions");
            ui.SendMessage(student.getFio() + " incorrectly answered " + student.getIncorrectlyAnswerCount() + " questions");

            ui.SendMessage("-----------The end.-------------");

        } catch (Exception | Error e) {
            ui.SendMessageError(e.getMessage());
        }

    }

    private void init() {
        context.setQuestions(context.getService().getQuestions());

        var ui = context.getUi();

        ui.SendMessage("Enter your name:");
        String name = ui.GetString();

        context.setStudent(new Student(name));

    }

    private void processOneStep(Question question) {

        displayQuestion(question);
        displayAnswers(question.getAnswers());

        Answer humanAnswer = new Answer(context.getUi().GetString());

        if (humanAnswer.equals(question.getCorrectAnswer())){
            context.getStudent().increaseCorrectAnswerCount();
        } else {
            context.getStudent().increaseIncorrectlyAnswerCount();
        }
    }

    private void displayQuestion(Question question) {
        context.getUi().SendMessage(question.getQuestion());
    }

    private void displayAnswers(List<Answer> answers) {

        int i = 1;

        for (Answer answer : answers) {
            String prefix = " [" + (i++) + "] ";
            context.getUi().SendMessage(prefix + answer.get());
        }
    }
}
