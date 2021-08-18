package ru.otus.gpbu.pse.homework03.dao;

import ru.otus.gpbu.pse.homework03.domain.Question;

public interface QuestionParser {
    Question getFromLine(String line);
}
