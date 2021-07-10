package ru.otus.gpbu.pse.homework01;

import ru.otus.gpbu.pse.homework01.dao.GetQuestionsDaoFromCsv;
import ru.otus.gpbu.pse.homework01.service.GetQuestionsServiceSimple;

public class Main {
    private static final String CSV_FILE = "D:\\Develop\\Обучение\\HomeWork\\HomeWork01\\archive\\questions-list.csv";

    public static void main(String[] args) {
        System.out.println("HomeWork01");
        try{
            var service =  new GetQuestionsServiceSimple(new GetQuestionsDaoFromCsv(CSV_FILE));
            System.out.println(service.getQuestions());
        } catch (Error | Exception e) {
            e.printStackTrace();
        }

    }

}
