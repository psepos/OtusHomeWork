package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.listener;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;

public class MyStudentListener implements StateMachineListener<ApplicationState, ApplicationEvent> {
    @Override
    public void stateChanged(State<ApplicationState, ApplicationEvent> state, State<ApplicationState, ApplicationEvent> state1) {

    }

    @Override
    public void stateEntered(State<ApplicationState, ApplicationEvent> state) {

    }

    @Override
    public void stateExited(State<ApplicationState, ApplicationEvent> state) {

    }

    @Override
    public void eventNotAccepted(Message<ApplicationEvent> message) {

    }

    @Override
    public void transition(Transition<ApplicationState, ApplicationEvent> transition) {

    }

    @Override
    public void transitionStarted(Transition<ApplicationState, ApplicationEvent> transition) {

    }

    @Override
    public void transitionEnded(Transition<ApplicationState, ApplicationEvent> transition) {

    }

    @Override
    public void stateMachineStarted(StateMachine<ApplicationState, ApplicationEvent> stateMachine) {

    }

    @Override
    public void stateMachineStopped(StateMachine<ApplicationState, ApplicationEvent> stateMachine) {

    }

    @Override
    public void stateMachineError(StateMachine<ApplicationState, ApplicationEvent> stateMachine, Exception e) {

    }

    @Override
    public void extendedStateChanged(Object o, Object o1) {

    }

    @Override
    public void stateContext(StateContext<ApplicationState, ApplicationEvent> stateContext) {

    }
}
