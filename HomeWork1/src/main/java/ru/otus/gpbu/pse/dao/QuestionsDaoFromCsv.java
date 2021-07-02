package ru.otus.gpbu.pse.dao;

import ru.otus.gpbu.pse.domain.Question;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionsDaoFromCsv implements QuestionsDao {

    private final String csvFileName;

    public QuestionsDaoFromCsv(String csvFilename){
        this.csvFileName = csvFilename;
    }


    public List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(csvFileName)).getFile());

        return questions;
    }

}
