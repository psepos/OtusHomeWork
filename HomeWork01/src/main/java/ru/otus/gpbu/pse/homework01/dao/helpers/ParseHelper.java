package ru.otus.gpbu.pse.homework01.dao.helpers;

import ru.otus.gpbu.pse.homework01.domain.Answer;
import ru.otus.gpbu.pse.homework01.domain.Question;

import java.util.Scanner;

public class ParseHelper {

    private static final String CSV_WORD_DELIMITER = ";";
    private static final String STRING_EMPTY = "";

    public Question parseQuestionFromLine(String line) throws ParseHelperException {

        if (line.equals(STRING_EMPTY)) {
            throw new ParseHelperException("Empty line.");
        }

        try {
            Scanner scanner = new Scanner(line);

            scanner.useDelimiter(CSV_WORD_DELIMITER);

            String questionString = scanner.next();
            Question question = new Question(questionString);

            while (scanner.hasNext()) {
                question.addAnswer(new Answer(scanner.next()));
            }

            return question;

        } catch (Exception e) {
            throw new ParseHelperException(e.getMessage());
        }


    }
}
