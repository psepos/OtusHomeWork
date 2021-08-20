package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.config.MyMessageSource;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.MyStudentTestUI;

@Component
public class InitAction extends MyStudentAction implements Action<ApplicationState, ApplicationEvent> {

    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {
        super.SendMessage("strings.welcome");
    }
}
