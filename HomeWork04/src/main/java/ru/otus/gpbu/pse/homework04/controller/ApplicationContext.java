package ru.otus.gpbu.pse.homework04.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.MessageSource;
import ru.otus.gpbu.pse.homework04.config.Environment;
import ru.otus.gpbu.pse.homework04.domain.Student;
import ru.otus.gpbu.pse.homework04.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework04.states.ApplicationStates;
import ru.otus.gpbu.pse.homework04.ui.MyStudentTestUI;

public class ApplicationContext {

    private static ApplicationContext instance;

    public static ApplicationContext getInstance(){
        return instance;
    }

    @Getter @Setter
    private Student student;

    @Getter @Setter
    private Integer step = 0;

    @Getter @Setter
    private GetQuestionsService service;

    @Getter @Setter
    private MyStudentTestUI ui;

    @Getter @Setter
    private MessageSource messageSource;

    @Getter @Setter
    private Environment environment;

    @Getter @Setter
    private ApplicationStates state;


    public void nextStep() {
        this.step++;
    }

}
