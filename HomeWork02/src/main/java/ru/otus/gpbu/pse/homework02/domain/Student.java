package ru.otus.gpbu.pse.homework02.domain;

public class Student {

    private final String fio;
    private Integer correctlyAnswerCount;
    private Integer incorrectlyAnswerCount;

    public Student(String fio) {
        this.fio = fio;
        this.correctlyAnswerCount = 0;
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
