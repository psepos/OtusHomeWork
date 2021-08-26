package ru.otus.gpbu.pse.homework04.MyStudent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework04.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework04.MyStudent.domain.Question;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Component
public class GetQuestionsDaoFromCsv implements GetQuestionsDao {

    @Autowired
    private Environment env;

    @Autowired
    private QuestionParser parser;

    private final List<Question> questions = new ArrayList<>();

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

    private String getCsvFile(){

        if (env.getLocale().equals("")) { return env.getCsvFile();}
        return env.getCsvFile().replace(".csv","_" + env.getLocale() + ".csv");

    }

    private Path getPath() throws URISyntaxException, IOException {
        var uri = ClassLoader.getSystemResource(this.getCsvFile()).toURI();
        final Map<String, String> env = new HashMap<>();
        final String[] array = uri.toString().split("!");
        final FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
        return fs.getPath(array[1]);
    }


}
