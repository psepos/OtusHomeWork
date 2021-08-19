package ru.otus.gpbu.pse.homework03.MyStudent.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.state.ApplicationState;
import ru.otus.gpbu.pse.homework03.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework03.MyStudent.config.MyMessageSource;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework03.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.MyStudentTestUI;

@Component
public class MyStudentContext {

    @Getter @Setter
    private Student student;

    @Getter
    private Integer step = 0;

    @Getter @Setter @Autowired
    private GetQuestionsService service;

    @Getter @Setter @Autowired
    private MyStudentTestUI ui;

    @Getter @Setter @Autowired
    private MyMessageSource messageSource;

    @Getter @Setter @Autowired
    private Environment environment;


    private ApplicationState state;

    public void nextStep() {
        this.step++;
    }

}
