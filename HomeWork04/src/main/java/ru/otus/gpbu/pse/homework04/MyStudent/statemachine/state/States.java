package ru.otus.gpbu.pse.homework04.MyStudent.statemachine.state;

public enum States {
    START,
    INIT,
    LOGGED,
    BEGIN,
    HAS_NEXT,
    CURRENT_QUESTION,
    PRINT_CURRENT_QUESTION,
    WAIT_FOR_ANSWER,
    HUMAN_ANSWER,
    PRINT_RESULT,
    END,
    QUIT
}
