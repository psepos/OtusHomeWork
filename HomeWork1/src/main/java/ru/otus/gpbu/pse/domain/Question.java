package ru.otus.gpbu.pse.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private final List<Answer> answers = new ArrayList<>();

    public Question(String question){ this.question = question; }

    public String getQuestion(){ return this.question; }

    public List<Answer> getAnswers(){ return new ArrayList<>(answers); }

    public boolean addAnswer(Answer answer) { return this.answers.add(answer);}

}
