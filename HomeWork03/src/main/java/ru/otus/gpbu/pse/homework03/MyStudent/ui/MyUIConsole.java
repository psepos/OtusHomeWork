package ru.otus.gpbu.pse.homework03.MyStudent.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.config.MyMessageSource;

import java.util.Scanner;

@Component
public class MyUIConsole implements MyUI {

    @Autowired
    MyMessageSource msg;

    @Override
    public void SendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void SendMessageById(String messageId) {
        SendMessage(msg.getMessage(messageId));
    }

    @Override
    public void SendMessageById(String messageId, String param) {
        SendMessage(msg.getMessage(messageId, param));
    }

    @Override
    public String GetString() {
        return new Scanner(System.in).nextLine();
    }
}
