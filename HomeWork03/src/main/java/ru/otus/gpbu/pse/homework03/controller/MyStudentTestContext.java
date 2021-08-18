package ru.otus.gpbu.pse.homework03.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.MessageSource;
import ru.otus.gpbu.pse.homework03.config.Environment;
import ru.otus.gpbu.pse.homework03.domain.Student;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

public class MyStudentTestContext {

    @Getter @Setter
    private Student student;

    @Getter
    private Integer step = 0;

    @Getter @Setter
    private GetQuestionsService service;

    @Getter @Setter
    private MyStudentTestUI ui;

    @Getter @Setter
    private MessageSource messageSource;

    @Getter @Setter
    private Environment environment;

    public void nextStep() {
        this.step++;
    }

}
