package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.controller.MyContext;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

@Component
public class WaitForLoginAction extends MyAction implements Action<ApplicationState, ApplicationEvent> {

    @Autowired
    MyContext context;

    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {
        String studentName = "";

        ui.SendMessageById("strings.enter-your-name");
        //studentName = ui.GetString();
    }
}