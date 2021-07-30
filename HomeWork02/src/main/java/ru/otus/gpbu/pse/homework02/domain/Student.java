package ru.otus.gpbu.pse.homework02.domain;

public class Student {

    private final String fio;
    Integer correctAnswerCount;

    public Student(String fio) {
        this.fio = fio;
        this.correctAnswerCount = 0;
    }

    public String getFio(String fio){
        return fio;
    }

    public Integer getCorrectAnswerCount(){
        return correctAnswerCount;
    }

    public void increaseCorrectAnswerCount(){
        correctAnswerCount++;
    }

}
