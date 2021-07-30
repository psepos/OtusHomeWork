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

    private Student student;

    public MyQuestionControllerMain(GetQuestionsService service, MyQuestionsUI ui) {
        this.service = service;
        this.ui = ui;
    }

    @Override
    public void run() {
        try {

            this.ui.SendMessage("Home work 02");

            List<Question> questions = service.getQuestions();

            this.initStudent();

            int i = 1;

            for (Question question : questions) {
                processOneQuestion(i++, question);
            }

            ui.SendMessage("-----------The end.-------------");

        } catch (Exception | Error e) {
            ui.SendMessageError(e.getMessage());
        }

    }

    private void initStudent(){
        ui.SendMessage("Enter your name:");
        String name = ui.GetString();
        this.student = new Student(name);
    }

    private void processOneQuestion(int i, Question question) {
        ui.SendMessage("-----------Question N" + i + "-------------");
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
