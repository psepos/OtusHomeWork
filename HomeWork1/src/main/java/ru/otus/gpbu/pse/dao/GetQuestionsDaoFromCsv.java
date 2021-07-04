package ru.otus.gpbu.pse.dao;

import ru.otus.gpbu.pse.domain.Question;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetQuestionsDaoFromCsv implements GetQuestionsDao {

    private final String csvFileName;
    private List<Question> questions;

    public GetQuestionsDaoFromCsv(String csvFilename) {
        this.csvFileName = csvFilename;
    }

    private List<Question> readAllFromCsv() {

        questions = new ArrayList<>();

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(csvFileName)).getFile());

        return this.questions;
    }

    private void parseOneLineCsv(String lineToParse) {

    }

    public List<Question> getQuestions() {
        return readAllFromCsv();
    }

}
