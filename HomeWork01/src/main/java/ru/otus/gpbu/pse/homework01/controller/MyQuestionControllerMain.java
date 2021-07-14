package ru.otus.gpbu.pse.homework01.controller;

import ru.otus.gpbu.pse.homework01.domain.Answer;
import ru.otus.gpbu.pse.homework01.domain.Question;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework01.ui.MyQuestionsUi;

import java.util.List;

public class MyQuestionControllerMain implements MyQuestionController {

    private final GetQuestionsService service;
    private final MyQuestionsUi ui;

    public MyQuestionControllerMain(GetQuestionsService service, MyQuestionsUi ui) {
        this.service = service;
        this.ui = ui;
    }

    @Override
    public void run() {
        ui.SendMessage("-----------Home work 1-------------");
        ui.SendMessage("-----------Use configuring the Spring-------------");

        List<Question> questions = service.getQuestions();
        ui.SendMessage("-----------Answer " + questions.size() + " questions -------------");

        int i = 1;

        for (Question question : questions
        ) {
            ui.SendMessage("-----------Question N" + (i++) + "-------------");
            ui.SendMessage(question.getQuestion());
            ui.SendMessage("Your answer:");
            Answer answer = new Answer(ui.getMessage());

            if (answer.checkingCorrectAnswer(question.getCorrectAnswers())) {
                ui.SendMessage("This is the correct answer.");
            } else {
                ui.SendMessage("This is an incorrect answer");
            }
        }

        ui.SendMessage("-----------The end.-------------");
    }
}
