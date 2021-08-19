package ru.otus.gpbu.pse.homework03.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private final List<Answer> answers = new ArrayList<>();

    private Answer correctAnswer;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public boolean addAnswer(Answer answer) {
        return this.answers.add(answer);
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString(){
        return question;
    }

}
