package ru.otus.gpbu.pse.homework04.dao;

import ru.otus.gpbu.pse.homework04.domain.Answer;
import ru.otus.gpbu.pse.homework04.domain.Question;

import java.util.Scanner;

public class QuestionParser {

    private static final String STRING_EMPTY = "";
    private final String csvDelimiter;

    public QuestionParser(String csvDelimiter) {
        this.csvDelimiter = csvDelimiter;
    }

    public Question getFromLine(String line) {

        if (line.equals(STRING_EMPTY)) {
            throw new DaoException("Empty line.");
        }

        try {
            Scanner scanner = new Scanner(line);

            scanner.useDelimiter(this.csvDelimiter);

            String questionString = scanner.next();
            Question question = new Question(questionString);

            int correctAnswerInOrder = scanner.nextInt();

            while (scanner.hasNext()) {
                question.addAnswer(new Answer(scanner.next()));
            }

            if (question.getAnswers().size() > 0) {
                question.setCorrectAnswer(question.getAnswers().get(correctAnswerInOrder - 1));
            } else {
                question.setCorrectAnswer(new Answer(""));
            }

            return question;

        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
}
