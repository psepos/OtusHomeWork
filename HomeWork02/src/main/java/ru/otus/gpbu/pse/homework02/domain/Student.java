package ru.otus.gpbu.pse.homework02.domain;

public class Student {

    private final String fio;
    private Integer correctAnswerCount;
    private Integer faultAnswerCount;

    public Student(String fio) {
        this.fio = fio;
        this.correctAnswerCount = 0;
    }

    public String getFio(String fio) {
        return this.fio;
    }

    public Integer getCorrectAnswerCount() {
        return this.correctAnswerCount;
    }

    public void increaseCorrectAnswerCount() {
        this.correctAnswerCount++;
    }

    public Integer getFaultAnswerCount() {
        return faultAnswerCount;
    }

    public void increaseAnswerCount() {
        this.faultAnswerCount++;
    }
}
