package ru.otus.gpbu.pse.homework02.dao;

import ru.otus.gpbu.pse.homework02.domain.Answer;
import ru.otus.gpbu.pse.homework02.domain.Question;

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

    private static final String STRING_EMPTY = "";
    private final String csvDelimiter;

    private final String csvFile;
    private final List<Question> questions = new ArrayList<>();


    public GetQuestionsDaoFromCsv(String csvFile, String csvDelimiter) {
        this.csvFile = csvFile;
        this.csvDelimiter = csvDelimiter;
    }

    private List<Question> readFromCsv() throws DaoException {

        try {

            Files.lines(this.getPath(), StandardCharsets.UTF_8).forEach(s -> questions.add(this.parseQuestionFromLine(s)));

        } catch (Exception | Error e) {
            throw new DaoException(e + " " + Arrays.toString(e.getStackTrace()));
        }

        return this.questions;
    }

    public Question parseQuestionFromLine(String line) {

        if (line.equals(STRING_EMPTY)) {
            throw new DaoException("Empty line.");
        }

        try {
            Scanner scanner = new Scanner(line);

            scanner.useDelimiter(this.csvDelimiter);

            String questionString = scanner.next();
            Question question = new Question(questionString);

            while (scanner.hasNext()) {
                question.addAnswer(new Answer(scanner.next()));
            }

            if (question.getAnswers().size() > 0) {
                question.setCorrectAnswer(question.getAnswers().get(0));
            } else {
                question.setCorrectAnswer(new Answer(""));
            }

            return question;

        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Path getPath() throws URISyntaxException, IOException {
        var uri = ClassLoader.getSystemResource(csvFile).toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        return fs.getPath(array[1]);
    }

    public List<Question> getQuestions() {
        return readFromCsv();
    }


}
