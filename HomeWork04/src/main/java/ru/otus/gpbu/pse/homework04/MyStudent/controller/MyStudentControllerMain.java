package ru.otus.gpbu.pse.homework04.MyStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@Controller
public class MyStudentControllerMain implements MyStudentController {

    @Autowired
    private final StateMachine<States, Events> stateMachine;

    public MyStudentControllerMain(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void run() {
        stateMachine.sendEvent(Events.DO_INIT);
    }
}