package ru.otus.gpbu.pse.homework03.MyStudent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import ru.otus.gpbu.pse.homework03.MyStudent.state.ApplicationState;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;

//@Configuration
//@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<ApplicationState, ApplicationEvent> {


}
