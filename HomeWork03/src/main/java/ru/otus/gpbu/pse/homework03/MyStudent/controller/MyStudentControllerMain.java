package ru.otus.gpbu.pse.homework03.MyStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import ru.otus.gpbu.pse.homework03.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework03.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.States;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.MyUI;

import java.util.List;

@Controller
public class MyStudentControllerMain implements MyStudentController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run() {

        stateMachine.sendEvent(Events.DO_INIT);
    }
}