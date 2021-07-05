package ru.otus.gpbu.pse.homework01.dao;

import ru.otus.gpbu.pse.homework01.domain.Question;

import java.util.List;

public interface GetQuestionsDao {
    List<Question> getQuestions();
}
