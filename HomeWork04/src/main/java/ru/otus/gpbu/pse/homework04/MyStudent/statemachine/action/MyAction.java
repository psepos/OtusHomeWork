package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.ui.MyUI;

@Component
public class MyAction {
    @Autowired
    protected MyUI ui;

}
