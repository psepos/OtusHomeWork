package ru.otus.gpbu.pse.homework04.MyStudent.dao;

import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;

import java.util.List;

public interface GetQuestionsDao {
    List<Question> getQuestions();
}
