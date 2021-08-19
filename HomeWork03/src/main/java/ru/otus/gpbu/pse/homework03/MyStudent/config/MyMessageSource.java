package ru.otus.gpbu.pse.homework03.MyStudent.config;

public interface MyMessageSource {
    String getMessage(String variable);
    String getMessage(String variable, String param);
}
