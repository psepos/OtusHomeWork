package ru.otus.gpbu.pse.homework03.dao;

import ru.otus.gpbu.pse.homework03.domain.Question;

import java.util.List;

public interface GetQuestionsDao {
    List<Question> getQuestions();
}
