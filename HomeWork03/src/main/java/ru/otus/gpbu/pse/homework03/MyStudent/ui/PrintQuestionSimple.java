package ru.otus.gpbu.pse.homework03.MyStudent.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;

@Component
public class PrintQuestionSimple implements PrintQuestion {

    @Autowired
    private MyUI ui;

    @Override
    public void print(Question question) {
        printQ(question);
        printA(question);
    }

    private void printQ(Question question){
        ui.SendMessage(question.toString());
    }

    private void printA(Question question){

        String prefix = "   ";

        for (Answer answer : question.getAnswers()) {
            ui.SendMessage(prefix + answer.toString());
        }

    }
}
