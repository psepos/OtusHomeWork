package ru.otus.gpbu.pse.homework03.MyStudent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.MyStudent.config.Environment;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Answer;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;

import java.util.Scanner;

@Component
public class QuestionParserSimple implements QuestionParser{

    private static final String STRING_EMPTY = "";

    @Autowired
    private Environment env;

    @Override
    public Question getFromLine(String line) {

        if (line.equals(STRING_EMPTY)) {
            throw new DaoException("Empty line.");
        }

        try {
            Scanner scanner = new Scanner(line);

            scanner.useDelimiter(env.getCsvDelimiter());

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
