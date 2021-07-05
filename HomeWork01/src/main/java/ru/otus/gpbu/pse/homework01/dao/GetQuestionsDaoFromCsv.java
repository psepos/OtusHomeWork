package ru.otus.gpbu.pse.homework01.dao;

import ru.otus.gpbu.pse.homework01.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsDaoFromCsv implements GetQuestionsDao {

    private final String csvFileName;
    private final List<Question> questions = new ArrayList<>();

    public GetQuestionsDaoFromCsv(String csvFilename) {
        this.csvFileName = csvFilename;
    }

    private List<Question> readAllFromCsv() {

        questions.clear();

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

  */      return this.questions;
    }

    private void parseOneLineCsv(String lineToParse) {

    }

    public List<Question> getQuestions() {
        return readAllFromCsv();
    }

}
