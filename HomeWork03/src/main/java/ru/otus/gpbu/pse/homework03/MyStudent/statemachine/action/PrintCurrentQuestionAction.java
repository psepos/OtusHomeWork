package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.States;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.PrintQuestion;

@Component
public class PrintCurrentQuestionAction extends MyAction implements Action<States, Events> {

    @Autowired
    private PrintQuestion printQuestion;

    @Override
    public void execute(StateContext<States, Events> stateContext) {

        var variables = stateContext.getExtendedState().getVariables();
        var currentQuestion = (Question) variables.get(Variables.CURRENT_QUESTION);

        printQuestion.print(currentQuestion);

    }
}
