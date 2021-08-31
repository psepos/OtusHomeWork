package ru.otus.gpbu.pse.homework04.MyStudent.ui;

public interface MyUI {
    void sendMessage(String message);
    void sendMessageById(String messageId);
    void sendMessageById(String messageId, String param);
    String getString();
}
