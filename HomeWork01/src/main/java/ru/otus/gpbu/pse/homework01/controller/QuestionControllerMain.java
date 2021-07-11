package ru.otus.gpbu.pse.homework01.controller;

import ru.otus.gpbu.pse.homework01.domain.Question;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsService;

import java.util.List;

public class QuestionControllerMain implements QuestionController{

    private final GetQuestionsService service;

    public QuestionControllerMain(GetQuestionsService service) {
        this.service = service;
    }

    @Override
    public void run() {
        List<Question> questions = service.getQuestions();

    }
}
