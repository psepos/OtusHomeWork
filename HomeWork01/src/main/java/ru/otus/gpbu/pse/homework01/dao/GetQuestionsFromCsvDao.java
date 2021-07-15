package ru.otus.gpbu.pse.homework01.dao;

import ru.otus.gpbu.pse.homework01.dao.helpers.ParseHelper;
import ru.otus.gpbu.pse.homework01.domain.Question;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetQuestionsFromCsvDao implements GetQuestionsDao {

    private final String csvFile;
    private final List<Question> questions = new ArrayList<>();


    public GetQuestionsFromCsvDao(String csvFile) {
        this.csvFile = csvFile;
    }

    private List<Question> readFromCsv() throws DaoException {

        try {
            ParseHelper parser = new ParseHelper();

            Files
                    .lines(Paths.get(csvFile), StandardCharsets.UTF_8)
                    .forEach(s -> questions.add(parser.parseQuestionFromLine(s)));

        } catch (Exception | Error e) {
            throw new DaoException(e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }

        return this.questions;
    }

    public List<Question> getQuestions() {
        return readFromCsv();
    }

}
