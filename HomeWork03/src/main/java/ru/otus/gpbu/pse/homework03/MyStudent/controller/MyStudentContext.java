package ru.otus.gpbu.pse.homework03.MyStudent.controller;

import ru.otus.gpbu.pse.homework03.MyStudent.domain.Student;

public interface MyStudentContext {
    Student getStudent();
    void  setStudent(Student student);

    Integer getStep();
    void nextStep();
}
