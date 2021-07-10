package ru.otus.gpbu.pse.homework01.dao;

import ru.otus.gpbu.pse.homework01.dao.helpers.ParseHelper;
import ru.otus.gpbu.pse.homework01.dao.helpers.ParseHelperException;
import ru.otus.gpbu.pse.homework01.domain.Question;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GetQuestionsDaoFromCsv implements GetQuestionsDao {

    private final String csvFileName;
    private final List<Question> questions = new ArrayList<>();


    public GetQuestionsDaoFromCsv(String csvFilename) {
        this.csvFileName = csvFilename;
    }

    private List<Question> readFromCsv() throws DaoException {

        try {
            ParseHelper lineParse = new ParseHelper();

            Files
                    .lines(Paths.get(csvFileName), StandardCharsets.UTF_8)
                    .forEach(s -> questions.add(lineParse.parseQuestionFromLine(s)));

        } catch (Exception | Error e) {
            throw new DaoException(e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }


/*        Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(csvFileName)).getFile());
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            // считываем остальные строки в цикле
            line = reader.readLine();
        }

  */
        return this.questions;
    }

    public List<Question> getQuestions() {
        return readFromCsv();
    }

}
