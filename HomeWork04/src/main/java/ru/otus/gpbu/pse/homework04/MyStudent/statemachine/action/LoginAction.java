package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@Component
public class LoginAction extends MyAction implements Action<States, Events> {


    @Override
    public void execute(StateContext<States, Events> stateContext) {
        ui.SendMessageById("strings.enter-your-name");

        var studentName = ui.GetString();
        var variables = stateContext.getExtendedState().getVariables();
        variables.put(Variables.STUDENT, new Student(studentName));

    }
}