package ru.otus.gpbu.pse.homework01.ui;


import java.util.Scanner;

public class MyQuestionsUIConsole implements MyQuestionsUi {

    @Override
    public String getMessage() {
        return new Scanner(System.in).next();
    }

    @Override
    public void SendMessage(String message) {
        System.out.println(message);
    }
}
