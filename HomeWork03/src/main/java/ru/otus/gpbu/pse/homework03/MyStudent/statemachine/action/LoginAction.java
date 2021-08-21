package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.controller.MyContext;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

@Component
public class LoginAction extends MyAction implements Action<ApplicationState, ApplicationEvent> {

    @Autowired
    MyContext context;

    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {
        ui.SendMessageById("strings.enter-your-name");

        var studentName = ui.GetString();

        stateContext.getExtendedState().getVariables().put("STUDENT", new Student(studentName));

        ui.SendMessageById("strings.after-logon");
    }
}