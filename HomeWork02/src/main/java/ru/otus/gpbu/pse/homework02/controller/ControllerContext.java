package ru.otus.gpbu.pse.homework02.controller;

import ru.otus.gpbu.pse.homework02.domain.Question;
import ru.otus.gpbu.pse.homework02.domain.Student;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

import java.util.List;

public class ControllerContext {

    private Student student;
    private List<Question> questions;

    private Integer step;
    private Integer numberOfCorrectAnswersToEnd;

    private GetQuestionsService service;
    private MyQuestionsUI ui;

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

    public Integer getStep() {
        return step;
    }

    public void increaseStep() {
        this.step++;
    }

    public Integer getNumberOfCorrectAnswersToEnd() {
        return numberOfCorrectAnswersToEnd;
    }

    public void setNumberOfCorrectAnswersToEnd(Integer numberOfCorrectAnswersToEnd) {
        this.numberOfCorrectAnswersToEnd = numberOfCorrectAnswersToEnd;
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
