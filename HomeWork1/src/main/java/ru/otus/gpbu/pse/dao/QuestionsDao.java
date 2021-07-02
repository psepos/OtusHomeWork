package ru.otus.gpbu.pse.dao;

import ru.otus.gpbu.pse.domain.Question;

import java.util.List;

public interface QuestionsDao {
    List<Question> getQuestions();
}
