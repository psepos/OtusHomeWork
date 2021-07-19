package ru.otus.gpbu.pse.homework01.ui;

public interface MyQuestionsUI {
    String getMessage();
    void SendMessage(String message);
    void SendMessageError(String message);
    void SendMessageCorrectAnswer(String message);
    void SendMessageIncorrectAnswer(String message);
}
