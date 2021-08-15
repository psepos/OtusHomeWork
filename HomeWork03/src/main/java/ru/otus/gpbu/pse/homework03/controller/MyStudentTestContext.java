package ru.otus.gpbu.pse.homework03.controller;

import org.springframework.context.MessageSource;
import ru.otus.gpbu.pse.homework03.config.Environment;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

public class MyStudentTestContext {

    private Student student;
    private Integer step = 0;
    private GetQuestionsService service;
    private MyStudentTestUI ui;
    private MessageSource messageSource;
    private Environment environment;

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

    public GetQuestionsService getService() {
        return service;
    }

    public void setService(GetQuestionsService service) {
        this.service = service;
    }

    public MyStudentTestUI getUi() {
        return ui;
    }

    public void setUi(MyStudentTestUI ui) {
        this.ui = ui;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
