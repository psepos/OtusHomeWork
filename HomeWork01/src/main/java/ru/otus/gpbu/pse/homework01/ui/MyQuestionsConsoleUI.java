package ru.otus.gpbu.pse.homework01.ui;

import java.util.Scanner;

public class MyQuestionsConsoleUI implements MyQuestionsUi {

    static final String ANSI_RESET = (char) 27 + "[0m";
    static final String ANSI_RED = (char) 27 + "[31m";
    static final String ANSI_GREEN = (char) 27 + "[32m";

    @Override
    public String getMessage() {
        return new Scanner(System.in).next();
    }

    @Override
    public void SendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void SendMessageError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    @Override
    public void SendMessageCorrectAnswer(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    @Override
    public void SendMessageIncorrectAnswer(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
}
