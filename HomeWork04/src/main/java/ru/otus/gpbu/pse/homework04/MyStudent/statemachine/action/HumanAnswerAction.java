package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.event.Events;
import ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state.States;

@Component
public class HumanAnswerAction extends MyAction implements Action<States, Events> {
    @Override
    public void execute(StateContext<States, Events> stateContext) {
        var variables = stateContext.getExtendedState().getVariables();

        Question currentQuestion = (Question) variables.get(Variables.CURRENT_QUESTION);
        Answer humanAnswer = (Answer) variables.get(Variables.HUMAN_ANSWER);
        Student student = (Student) variables.get(Variables.STUDENT);

        if (currentQuestion.getCorrectAnswer().equals(humanAnswer)) {
            student.increaseCorrectAnswerCount();
        } else {
            student.increaseIncorrectlyAnswerCount();
        }
    }
}
