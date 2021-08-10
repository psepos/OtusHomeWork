package ru.otus.gpbu.pse.homework03.domain;

public class Student {

    private final String fio;
    private Integer correctlyAnswerCount = 0;
    private Integer incorrectlyAnswerCount = 0;

    public Student(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return this.fio;
    }

    public Integer getCorrectlyAnswerCount() {
        return this.correctlyAnswerCount;
    }

    public void increaseCorrectAnswerCount() {
        this.correctlyAnswerCount++;
    }

    public Integer getIncorrectlyAnswerCount() {
        return incorrectlyAnswerCount;
    }

    public void increaseIncorrectlyAnswerCount() {
        this.incorrectlyAnswerCount++;
    }
}
