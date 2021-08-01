package ru.otus.gpbu.pse.homework02.controller;

import ru.otus.gpbu.pse.homework02.domain.Answer;
import ru.otus.gpbu.pse.homework02.domain.Question;
import ru.otus.gpbu.pse.homework02.domain.Student;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

import java.util.List;

public class MyQuestionControllerMain implements MyQuestionController {

    private final GetQuestionsService service;
    private final MyQuestionsUI ui;
    private final ControllerContext context = new ControllerContext();

    private Student student;

    public MyQuestionControllerMain(GetQuestionsService service, MyQuestionsUI ui) {
        this.service = service;
        this.ui = ui;
    }

    @Override
    public void run() {
        try {

            ui.SendMessage("Homework 02");

            initContext();


            for (Question question : context.getQuestions()) {
                processOneQuestion(question);
            }

            ui.SendMessage("-----------The end.-------------");

        } catch (Exception | Error e) {
            ui.SendMessageError(e.getMessage());
        }

    }


    private void initContext(){
        context.setQuestions(this.service.getQuestions());

        ui.SendMessage("Enter your name:");
        String name = ui.GetString();

        context.setStudent(new Student(name));

    }

    private void processOneQuestion(Question question) {
        this.outQuestion(question);
        this.outAnswers(question.getAnswers());
    }

    private void outQuestion(Question question) {
        ui.SendMessage(question.getQuestion());
    }

    private void outAnswers(List<Answer> answers) {

        int i = 1;

        for (Answer answer : answers) {
            String prefix = " [" + (i++) + "] ";
            ui.SendMessage(prefix + answer.get());
        }
    }
}
