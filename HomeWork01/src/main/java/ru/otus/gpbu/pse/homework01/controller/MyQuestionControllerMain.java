package ru.otus.gpbu.pse.homework01.controller;

import ru.otus.gpbu.pse.homework01.domain.Answer;
import ru.otus.gpbu.pse.homework01.domain.Question;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework01.ui.MyQuestionsUI;

import java.util.List;

public class MyQuestionControllerMain implements MyQuestionController {

    private final GetQuestionsService service;
    private final MyQuestionsUI ui;

    public MyQuestionControllerMain(GetQuestionsService service, MyQuestionsUI ui) {
        this.service = service;
        this.ui = ui;
    }

    @Override
    public void run() {
        try {
            List<Question> questions = this.init();

            ui.SendMessage("Home work 1");
            ui.SendMessage("Use configuring the Spring");
            ui.SendMessage(questions.size() + " questions");

            int i = 1;

            for (Question question : questions) {
                processOneQuestion(i++, question);
            }

            ui.SendMessage("-----------The end.-------------");

        } catch (Exception | Error e) {
            ui.SendMessageError(e.getMessage());
        }

    }

    private List<Question> init() {
        return service.getQuestions();
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
