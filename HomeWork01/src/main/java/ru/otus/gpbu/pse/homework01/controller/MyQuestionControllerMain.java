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
            List<Question> questions = init();

            ui.SendMessage("-----------Home work 1-------------");
            ui.SendMessage("-----------Use configuring the Spring-------------");
            ui.SendMessage("-----------Answer " + questions.size() + " questions -------------");

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
        ui.SendMessage(question.getQuestion());
        ui.SendMessage("Your answer:");
        Answer answer = new Answer(ui.getMessage());

        if (answer.checkingCorrectAnswer(question.getCorrectAnswers())) {
            ui.SendMessageCorrectAnswer("This is the correct answer.");
        } else {
            ui.SendMessageIncorrectAnswer("This is an incorrect answer");
        }
    }
}
