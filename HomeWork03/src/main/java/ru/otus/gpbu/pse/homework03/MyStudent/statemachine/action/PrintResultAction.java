package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework03.MyStudent.i18n.MyMessageSource;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.States;

@Component
public class PrintResultAction extends MyAction implements Action<States, Events> {

    @Autowired
    private MyMessageSource messageSource;

    @Autowired
    private Environment environment;

    @Override
    public void execute(StateContext<States, Events> stateContext) {

        var variables = stateContext.getExtendedState().getVariables();
        var student = (Student) variables.get(Variables.STUDENT);
        var passingScore = environment.getPassingScore();

        String testResult = messageSource.getMessage("strings.not-passed");

        if (student.getCorrectlyAnswerCount() >= passingScore) {
            testResult = messageSource.getMessage("strings.passed");
        }

        ui.SendMessageById("strings.student", student.toString());
        ui.SendMessageById("strings.test-passing-score", passingScore.toString());
        ui.SendMessageById("strings.correctly-answered", student.getCorrectlyAnswerCount().toString());
        ui.SendMessageById("strings.incorrectly-answered", student.getIncorrectlyAnswerCount().toString());
        ui.SendMessageById("strings.test-result", testResult);
    }
}
