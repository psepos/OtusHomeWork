package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@Component
public class WaitForAnswerAction extends MyAction implements Action<States, Events> {
    @Override
    public void execute(StateContext<States, Events> stateContext) {
        ui.SendMessageById("strings.enter-your-answer");

        Answer humanAnswer = new Answer(ui.GetString());
        stateContext.getExtendedState().getVariables().put(Variables.HUMAN_ANSWER, humanAnswer);

    }
}
