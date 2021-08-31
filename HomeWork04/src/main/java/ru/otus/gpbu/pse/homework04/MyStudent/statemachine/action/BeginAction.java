package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@Component
public class BeginAction extends MyAction implements Action<States, Events> {

    @Autowired
    private GetQuestionsService service;

    @Override
    public void execute(StateContext<States, Events> stateContext) {

        var variables = stateContext.getExtendedState().getVariables();
        var questions = service.getQuestions();

        variables.put(Variables.QUESTIONS, questions);
        variables.put(Variables.QUESTION_ITERATOR, questions.iterator());

        ui.sendMessageById("strings.begin-test");
    }
}
