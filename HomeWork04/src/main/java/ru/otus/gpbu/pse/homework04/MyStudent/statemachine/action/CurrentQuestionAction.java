package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

import java.util.Iterator;

@Component
public class CurrentQuestionAction extends MyAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> stateContext) {
        var variables = stateContext.getExtendedState().getVariables();
        var iterator = (Iterator<Question>) variables.get(Variables.QUESTION_ITERATOR);
        Question currentQuestion = iterator.next();
        variables.put(Variables.CURRENT_QUESTION, currentQuestion);
    }
}
