package ru.otus.gpbu.pse.homework03.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.config.Environment;
import ru.otus.gpbu.pse.homework03.config.MyMessageSource;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

@Component
public class MyStudentTestContext {

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

    public void nextStep() {
        this.step++;
    }

}
