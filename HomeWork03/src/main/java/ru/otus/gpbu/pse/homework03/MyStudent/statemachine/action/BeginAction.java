package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

public class BeginAction extends MyAction implements Action<ApplicationState, ApplicationEvent> {
    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {
        ui.SendMessageById("strings.after-logon");
    }
}
