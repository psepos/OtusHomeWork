package ru.otus.gpbu.pse.homework04.dao;

import ru.otus.gpbu.pse.homework04.domain.Question;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GetQuestionsDaoFromCsv implements GetQuestionsDao {

    private final QuestionParser parser;

    private final String csvFile;
    private final List<Question> questions = new ArrayList<>();


    public GetQuestionsDaoFromCsv(String csvFile, String csvDelimiter) {
        this.csvFile = csvFile;
        parser = new QuestionParser(csvDelimiter);
    }

    @Override
    public List<Question> getQuestions() {
        return readFromCsv();
    }

    private List<Question> readFromCsv() throws DaoException {

        try {

            Files.lines(this.getPath(), StandardCharsets.UTF_8).forEach(s -> questions.add(
                    parser.getFromLine(s))
            );

        } catch (Exception | Error e) {
            throw new DaoException(e + " " + Arrays.toString(e.getStackTrace()));
        }

        return this.questions;
    }

    private Path getPath() throws URISyntaxException, IOException {
        var uri = ClassLoader.getSystemResource(csvFile).toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        return fs.getPath(array[1]);
    }


}
