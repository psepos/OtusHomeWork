package ru.otus.gpbu.pse.homework04.MyStudent.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.statemachine.StateMachine;
import ru.otus.gpbu.pse.homework04.MyStudent.i18n.MyMessageSource;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@ShellComponent
public class ShellCommands {

    @Autowired
    private final StateMachine<States, Events> stateMachine;

    @Autowired
    private final MyMessageSource msg;

    public ShellCommands(StateMachine<States, Events> stateMachine, MyMessageSource msg) {
        this.stateMachine = stateMachine;
        this.msg = msg;
    }

    @ShellMethod(value = "Run test command")
    public void run(){
        stateMachine.sendEvent(Events.DO_INIT);
    }

}
