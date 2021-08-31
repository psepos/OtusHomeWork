package ru.otus.gpbu.pse.homework04.MyStudent.domain;

import lombok.Getter;

public class Student {

    private final String fio;

    @Getter
    private Integer correctlyAnswerCount = 0;

    @Getter
    private Integer incorrectlyAnswerCount = 0;

    public Student(String fio) {
        this.fio = fio;
    }

    public void increaseCorrectAnswerCount() {
        this.correctlyAnswerCount++;
    }

    public void increaseIncorrectlyAnswerCount() {
        this.incorrectlyAnswerCount++;
    }

    @Override
    public String toString(){
        return fio;
    }
}
