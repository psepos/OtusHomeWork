package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.state;

public enum ApplicationState {
    Start,
    Init,
    WaitForLogin,
    CurrentQuestion,
    WaitForAnswer,
    PrintResult,
    End,
    Quit
}
