package ru.otus.gpbu.pse.homework01;

import ru.otus.gpbu.pse.homework01.controller.MyQuestionController;
import ru.otus.gpbu.pse.homework01.controller.MyQuestionControllerMain;
import ru.otus.gpbu.pse.homework01.dao.GetQuestionsDaoFromCsv;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsServiceSimple;
import ru.otus.gpbu.pse.homework01.ui.MyQuestionsUIConsole;

public class Main {
    private static final String CSV_FILE = "D:\\Develop\\Обучение\\HomeWork\\HomeWork01\\archive\\questions-list.csv";

    public static void main(String[] args) {
        MyQuestionController controller = new MyQuestionControllerMain(new GetQuestionsServiceSimple(new GetQuestionsDaoFromCsv(CSV_FILE)),new MyQuestionsUIConsole());
        controller.run();

    }

}
