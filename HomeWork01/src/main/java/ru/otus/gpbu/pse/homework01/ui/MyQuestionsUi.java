package ru.otus.gpbu.pse.homework01.ui;

import ru.otus.gpbu.pse.homework01.domain.Answer;
import ru.otus.gpbu.pse.homework01.domain.Question;

public interface MyQuestionsUi {
    String getMessage();
    void SendMessage(String message);
    void SendMessageError(String message);
    void SendMessageCorrectAnswer(String message);
    void SendMessageIncorrectAnswer(String message);
}