package ru.otus.gpbu.pse.homework02.controller;

import ru.otus.gpbu.pse.homework02.domain.Question;
import ru.otus.gpbu.pse.homework02.domain.Student;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

import java.util.List;

public class AppContext {

    private Student student;

    private Integer step = 0;
    private Integer passingScore = 0;

    private GetQuestionsService service;
    private MyQuestionsUI ui;

    public void setStudent(Student currentStudent1){
        this.student = currentStudent1;
    }

    public Student getStudent(){
        return this.student;
    }

    public Integer getStep() {
        return step;
    }

    public void nextStep() {
        this.step++;
    }

    public Integer getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(Integer passingScore) {
        this.passingScore = passingScore;
    }

    public GetQuestionsService getService() {
        return service;
    }

    public void setService(GetQuestionsService service) {
        this.service = service;
    }

    public MyQuestionsUI getUi() {
        return ui;
    }

    public void setUi(MyQuestionsUI ui) {
        this.ui = ui;
    }
}
