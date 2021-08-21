package ru.otus.gpbu.pse.homework03.MyStudent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.ErrorAction;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.InitAction;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.QuitAction;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.WaitForLoginAction;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.listener.MyStudentListener;
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
                .states(EnumSet.allOf(ApplicationState.class));

    }

    @Override
    public void configure(final StateMachineConfigurationConfigurer<ApplicationState, ApplicationEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true);
                //.listener(new MyStudentListener());
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
                .target(ApplicationState.Quit)
                .event(ApplicationEvent.DoQuit)
                .action(quitAct(), errorAct())

                .and()

                .withExternal()
                .source(ApplicationState.Init)
                .target(ApplicationState.WaitForLogin)
                .event(ApplicationEvent.DoWaitForLogin)
                .action(waitForLoginAct(), errorAct());

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
    public Action<ApplicationState, ApplicationEvent> waitForLoginAct() {
        return new WaitForLoginAction();
    }
}
