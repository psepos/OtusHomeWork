package ru.otus.gpbu.pse.homework01.service;

import ru.otus.gpbu.pse.homework01.domain.Question;

import java.util.List;

public interface GetQuestionsService {
    List<Question> getQuestions();
}