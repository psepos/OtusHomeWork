package ru.otus.gpbu.pse.homework04.MyStudent.dao;

import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;

public interface QuestionParser {
    Question getFromLine(String line);
}
