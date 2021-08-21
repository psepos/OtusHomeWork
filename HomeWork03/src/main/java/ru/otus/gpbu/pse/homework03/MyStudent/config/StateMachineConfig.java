package ru.otus.gpbu.pse.homework03.MyStudent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.*;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<ApplicationState, ApplicationEvent> {
    @Override
    public void configure(final StateMachineStateConfigurer<ApplicationState, ApplicationEvent> states) throws Exception {
        states
                .withStates()
                .initial(ApplicationState.Start)
                .end(ApplicationState.Quit)
                .stateEntry(ApplicationState.Start, s -> s.getStateMachine().sendEvent(ApplicationEvent.DoInit))
                .stateEntry(ApplicationState.Init, s -> s.getStateMachine().sendEvent(ApplicationEvent.DoLogin))
                .stateEntry(ApplicationState.Logged, s -> s.getStateMachine().sendEvent(ApplicationEvent.DoBegin))
                .states(EnumSet.allOf(ApplicationState.class));
    }

    @Override
    public void configure(final StateMachineConfigurationConfigurer<ApplicationState, ApplicationEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<ApplicationState, ApplicationEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(ApplicationState.Start)
                .target(ApplicationState.Init)
                .event(ApplicationEvent.DoInit)
                .action(initAct(), errorAct())

                .and()

                .withExternal()
                .source(ApplicationState.Init)
                .target(ApplicationState.Logged)
                .event(ApplicationEvent.DoLogin)
                .action(LoginAct(), errorAct())

                .and()
                .withExternal()
                .source(ApplicationState.Logged)
                .target(ApplicationState.Begin)
                .event(ApplicationEvent.DoBegin)
                .action(quitAct(), errorAct())


        ;

    }

    @Bean
    public Action<ApplicationState, ApplicationEvent> initAct() {
        return new InitAction();
    }

    @Bean
    public Action<ApplicationState, ApplicationEvent> errorAct() {
        return new ErrorAction();
    }

    @Bean
    public Action<ApplicationState, ApplicationEvent> quitAct() {
        return new QuitAction();
    }

    @Bean
    public Action<ApplicationState, ApplicationEvent> LoginAct() {
        return new LoginAction();
    }

    @Bean
    public Action<ApplicationState, ApplicationEvent> BeginAct() {
        return new BeginAction();
    }
}
