package ru.otus.gpbu.pse.homework01;

import ru.otus.gpbu.pse.homework01.controller.MyQuestionController;
import ru.otus.gpbu.pse.homework01.controller.MyQuestionControllerMain;
import ru.otus.gpbu.pse.homework01.dao.GetQuestionsFromCsvDao;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsServiceSimple;
import ru.otus.gpbu.pse.homework01.ui.MyQuestionsConsoleUI;

public class Main {
    private static final String CSV_FILE = "/BOOT-INF/classes/data-source/questions-list.csv";

    public static void main(String[] args) {
        MyQuestionController controller = new MyQuestionControllerMain(new GetQuestionsServiceSimple(new GetQuestionsFromCsvDao(CSV_FILE)),new MyQuestionsConsoleUI());
        controller.run();
    }

}
