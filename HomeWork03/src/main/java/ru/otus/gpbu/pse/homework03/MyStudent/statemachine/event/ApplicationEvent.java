package ru.otus.gpbu.pse.homework03.MyStudent.statemachine.event;

public enum ApplicationEvent {
    DoInit,
    DoWaitForLogin,
    DoLogged,
    DoNextQuestion,
    DoWaitForAnswer,
    DoEnd,
    DoQuit
}
