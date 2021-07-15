package ru.otus.gpbu.pse.homework01.dao;

import ru.otus.gpbu.pse.homework01.dao.helpers.ParseHelper;
import ru.otus.gpbu.pse.homework01.domain.Question;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class GetQuestionsFromCsvDao implements GetQuestionsDao {

    private final String csvFile;
    private final List<Question> questions = new ArrayList<>();


    public GetQuestionsFromCsvDao(String csvFile) {
        this.csvFile = csvFile;
    }

    private List<Question> readFromCsv() throws DaoException {

        try {
            ParseHelper parser = new ParseHelper();

            var uri = ClassLoader.getSystemResource(csvFile).toURI();
            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");
            final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
            final Path path = fs.getPath(array[1]);

            Files
                    .lines(path, StandardCharsets.UTF_8)
                    .forEach(s -> questions.add(parser.parseQuestionFromLine(s)));

        } catch (Exception | Error e) {
            throw new DaoException(e + " " + Arrays.toString(e.getStackTrace()));
        }

        return this.questions;
    }

    public List<Question> getQuestions() {
        return readFromCsv();
    }

}
