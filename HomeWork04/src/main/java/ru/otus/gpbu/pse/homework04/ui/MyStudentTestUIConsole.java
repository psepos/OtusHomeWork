package ru.otus.gpbu.pse.homework04.ui;

import java.util.Scanner;

public class MyStudentTestUIConsole implements MyStudentTestUI {

    static final String ANSI_RESET = (char) 27 + "[0m";
    static final String ANSI_RED = (char) 27 + "[31m";


    @Override
    public void SendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void SendMessageError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    @Override
    public String GetString() {
        return new Scanner(System.in).nextLine();
    }

}
