package ru.otus.gpbu.pse.homework03.MyStudent.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;

@Component
public class MyStudentContextMain implements MyStudentContext {

    @Getter @Setter
    private Student student;

    @Getter
    private Integer step = 0;

    public void nextStep() {
        this.step++;
    }

}
