package ru.otus.gpbu.pse.homework03.MyStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import ru.otus.gpbu.pse.homework03.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;
import ru.otus.gpbu.pse.homework03.MyStudent.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event.ApplicationEvent;
import ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state.ApplicationState;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.MyUI;

import java.util.List;

@Controller
public class MyStudentControllerMain implements MyStudentController {

    @Autowired
    private MyContext context;

    @Autowired
    private MyUI ui;

    @Autowired
    private Environment environment;

    @Autowired
    private GetQuestionsService service;

    @Autowired
    private StateMachine<ApplicationState, ApplicationEvent> stateMachine;

    @Override
    public void run() {

        //stateMachine.sendEvent(ApplicationEvent.DoLogged);
        //stateMachine.sendEvent(ApplicationEvent.DoQuit);
    }

    private void init() {


        ui.SendMessageById("strings.enter-your-name");

        String name = ui.GetString();

        context.setStudent(new Student(name));

    }

    private void testStart() {
        for (Question question : service.getQuestions()) {
            runOneStep(question);
            context.nextStep();
        }
    }

    private void displayResults() {

        var student = context.getStudent();
        var passingScore = environment.getPassingScore();
/*
        String testResult = messageSource.getMessage("strings.not-passed");

        if (student.getCorrectlyAnswerCount() >= passingScore) {
            testResult = messageSource.getMessage("strings.passed");
        }

        ui.SendMessage(messageSource.getMessage("strings.student", student.toString()));
        ui.SendMessage(messageSource.getMessage("strings.test-passing-score",passingScore.toString()));
        ui.SendMessage(messageSource.getMessage("strings.total-answered",context.getStep().toString()));
        ui.SendMessage(messageSource.getMessage("strings.correctly-answered", student.getCorrectlyAnswerCount().toString()));
        ui.SendMessage(messageSource.getMessage("strings.incorrectly-answered", student.getIncorrectlyAnswerCount().toString()));
        ui.SendMessage(messageSource.getMessage("strings.test-result", testResult));
        */
    }


    private void runOneStep(Question question) {

        var locale = environment.getLocale();

        displayQuestion(question);
        displayAnswers(question.getAnswers());

        ui.SendMessageById( "strings.enter-your-answer");

        Answer humanAnswer = new Answer(ui.GetString());

        if (humanAnswer.equals(question.getCorrectAnswer())) {
            context.getStudent().increaseCorrectAnswerCount();
        } else {
            context.getStudent().increaseIncorrectlyAnswerCount();
        }
    }

    private void displayQuestion(Question question) {
        ui.SendMessageById(question.getQuestion());
    }

    private void displayAnswers(List<Answer> answers) {

        for (Answer answer : answers) {
            String prefix = "   ";
            ui.SendMessage(prefix + answer.toString());
        }
    }
}
