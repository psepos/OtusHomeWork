package ru.otus.gpbu.pse.homework02.controller;

import ru.otus.gpbu.pse.homework02.domain.Question;
import ru.otus.gpbu.pse.homework02.domain.Student;

import java.util.List;

public class ControllerContext {

    private Student student;
    private List<Question> questions;

    private Integer stepCount;

    public void setStudent(Student currentStudent1){
        this.student = currentStudent1;
    }

    public Student getStudent(){
        return this.student;
    }

    public void setQuestions(List<Question> questions1){
        this.questions = questions1;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Integer getStepCount() {
        return stepCount;
    }

    public void increaseCountAnswer() {
        this.stepCount++;
    }
}
