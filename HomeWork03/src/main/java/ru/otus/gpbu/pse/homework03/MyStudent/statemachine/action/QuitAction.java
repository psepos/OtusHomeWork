package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.States;

public class QuitAction extends MyAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        ui.SendMessageById("strings.quit");
    }
}
