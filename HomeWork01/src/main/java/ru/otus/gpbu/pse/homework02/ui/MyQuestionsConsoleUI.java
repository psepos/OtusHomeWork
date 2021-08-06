package ru.otus.gpbu.pse.homework02.ui;

public class MyQuestionsConsoleUI implements MyQuestionsUI {

    static final String ANSI_RESET = (char) 27 + "[0m";
    static final String ANSI_RED = (char) 27 + "[31m";
    static final String ANSI_GREEN = (char) 27 + "[32m";


    @Override
    public void SendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void SendMessageError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

}
