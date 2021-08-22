package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action.*;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.context.Variables;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.States;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.Events;

import java.util.EnumSet;
import java.util.Iterator;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {
    @Override
    public void configure(final StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.START)
                .end(States.QUIT)
                .stateEntry(States.INIT, s -> s.getStateMachine().sendEvent(Events.DO_LOGIN))
                .stateEntry(States.LOGGED, s -> s.getStateMachine().sendEvent(Events.DO_BEGIN))
                .stateEntry(States.BEGIN, s -> s.getStateMachine().sendEvent(Events.DO_HAS_NEXT))
                .stateEntry(States.HAS_NEXT, s -> {
                    var stateMachine = s.getStateMachine();
                    var variables = stateMachine.getExtendedState().getVariables();
                    var iterator = (Iterator<Question>) variables.get(Variables.QUESTION_ITERATOR);
                    if (iterator.hasNext()) {
                        s.getStateMachine().sendEvent(Events.DO_CURRENT_QUESTION);
                    } else {
                        s.getStateMachine().sendEvent(Events.DO_END);
                    }
                })
                .stateEntry(States.CURRENT_QUESTION, s -> s.getStateMachine().sendEvent(Events.DO_PRINT_CURRENT_QUESTION))
                .stateEntry(States.PRINT_CURRENT_QUESTION, s -> s.getStateMachine().sendEvent(Events.DO_WAIT_FOR_ANSWER))
                .stateEntry(States.WAIT_FOR_ANSWER, s -> s.getStateMachine().sendEvent(Events.DO_HUMAN_ANSWER))
                .stateEntry(States.HUMAN_ANSWER, s -> s.getStateMachine().sendEvent(Events.DO_HAS_NEXT))
                .stateEntry(States.END, s -> s.getStateMachine().sendEvent(Events.DO_PRINT_RESULT))
                .stateEntry(States.PRINT_RESULT, s -> s.getStateMachine().sendEvent(Events.DO_QUIT))
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(final StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                    .source(States.START).target(States.INIT)
                    .event(Events.DO_INIT).action(init(), error()).and()
                .withExternal()
                    .source(States.INIT).target(States.LOGGED)
                    .event(Events.DO_LOGIN).action(login(), error()).and()
                .withExternal()
                    .source(States.LOGGED).target(States.BEGIN)
                    .event(Events.DO_BEGIN).action(begin(), error()).and()
                .withExternal()
                    .source(States.BEGIN).target(States.HAS_NEXT)
                    .event(Events.DO_HAS_NEXT).and()
                .withExternal()
                    .source(States.HAS_NEXT).target(States.CURRENT_QUESTION)
                    .event(Events.DO_CURRENT_QUESTION).action(currentQuestion(), error()).and()
                .withExternal()
                    .source(States.CURRENT_QUESTION).target(States.PRINT_CURRENT_QUESTION)
                    .event(Events.DO_PRINT_CURRENT_QUESTION).action(printCurrentQuestion(), error()).and()
                .withExternal()
                    .source(States.PRINT_CURRENT_QUESTION).target(States.WAIT_FOR_ANSWER)
                    .event(Events.DO_WAIT_FOR_ANSWER).action(waitForAnswer(), error()).and()
                .withExternal()
                    .source(States.WAIT_FOR_ANSWER).target(States.HUMAN_ANSWER)
                    .event(Events.DO_HUMAN_ANSWER).action(humanAnswer(), error()).and()
                .withExternal()
                    .source(States.HUMAN_ANSWER).target(States.HAS_NEXT)
                    .event(Events.DO_HAS_NEXT).and()
                .withExternal()
                    .source(States.HAS_NEXT).target(States.END)
                    .event(Events.DO_END).action(end(), error()).and()
                .withExternal()
                    .source(States.END).target(States.PRINT_RESULT)
                    .event(Events.DO_PRINT_RESULT).action(printResult(), error()).and()
                .withExternal()
                    .source(States.PRINT_RESULT).target(States.QUIT)
                    .event(Events.DO_QUIT).action(quit(), error());

    }

    @Bean
    public Action<States, Events> init() {
        return new InitAction();
    }

    @Bean
    public Action<States, Events> error() {
        return new ErrorAction();
    }

    @Bean
    public Action<States, Events> quit() {
        return new QuitAction();
    }

    @Bean
    public Action<States, Events> login() {
        return new LoginAction();
    }

    @Bean
    public Action<States, Events> begin() {
        return new BeginAction();
    }

    @Bean
    public Action<States, Events> currentQuestion() {
        return new CurrentQuestionAction();
    }

    @Bean
    public Action<States, Events> printCurrentQuestion() {
        return new PrintCurrentQuestionAction();
    }

    @Bean
    public Action<States, Events> printResult() {
        return new PrintResultAction();
    }

    @Bean
    public Action<States, Events> humanAnswer() {
        return new HumanAnswerAction();
    }

    @Bean
    public Action<States, Events> waitForAnswer() {
        return new WaitForAnswerAction();
    }

    @Bean
    public Action<States, Events> end() {
        return new EndAction();
    }
}
