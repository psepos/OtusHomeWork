package ru.otus.gpbu.pse.homework03.MyStudent.dao;

import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;

public interface QuestionParser {
    Question getFromLine(String line);
}
