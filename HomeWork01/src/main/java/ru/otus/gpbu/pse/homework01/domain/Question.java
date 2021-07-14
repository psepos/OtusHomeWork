package ru.otus.gpbu.pse.homework01.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private final List<Answer> correctAnswers = new ArrayList<>();

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Answer> getCorrectAnswers() {
        return new ArrayList<>(correctAnswers);
    }

    public boolean addAnswer(Answer answer) {
        return this.correctAnswers.add(answer);
    }

}
