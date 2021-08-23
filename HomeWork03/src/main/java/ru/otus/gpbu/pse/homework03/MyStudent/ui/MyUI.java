package ru.otus.gpbu.pse.homework03.MyStudent.ui;

public interface MyUI {
    void SendMessage(String message);
    void SendMessageById(String messageId);
    void SendMessageById(String messageId, String param);
    String GetString();
}
