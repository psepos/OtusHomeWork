package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

import java.util.Iterator;

@Component
public class BeginAction extends MyAction implements Action<ApplicationState, ApplicationEvent> {

    @Autowired
    GetQuestionsService service;

    @Override
    public void execute(StateContext<ApplicationState, ApplicationEvent> stateContext) {

        var variables = stateContext.getExtendedState().getVariables();
        var questions = service.getQuestions();

        variables.put(Variables.QUESTIONS, questions);
        variables.put(Variables.QUESTION_STEP, 0);
        variables.put(Variables.QUESTION_ITERATOR, questions.iterator());

        ui.SendMessageById("strings.begin-test");
    }
}
