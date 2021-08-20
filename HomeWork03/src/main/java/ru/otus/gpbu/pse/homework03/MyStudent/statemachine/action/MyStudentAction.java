package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.config.MyMessageSource;
import ru.otus.gpbu.pse.homework03.MyStudent.ui.MyStudentTestUI;

@Component
public class MyStudentAction {
    @Autowired
    private MyStudentTestUI ui;

    @Autowired
    private MyMessageSource msg;

    protected void SendMessage(String message){
        ui.SendMessage(msg.getMessage(message));
    }

    protected void SendMessage(String message, String param){
        ui.SendMessage(msg.getMessage(message,param));
    }
}
