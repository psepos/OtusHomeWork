package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

import java.util.Iterator;

public class QuestionAction extends MyAction implements Action<ApplicationState, ApplicationEvent> {

    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {
        var variables = stateContext.getExtendedState().getVariables();
        var iterator = (Iterator<Question>)variables.get(Variables.QUESTION_ITERATOR);

    }
}
