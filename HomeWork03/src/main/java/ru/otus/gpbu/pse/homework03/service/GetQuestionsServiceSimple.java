package ru.otus.gpbu.pse.homework03.service;

import ru.otus.gpbu.pse.homework03.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework03.domain.Question;

import java.util.List;

public class GetQuestionsServiceSimple implements GetQuestionsService {

    private final GetQuestionsDao dao;

    public GetQuestionsServiceSimple(GetQuestionsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getQuestions() {

        return dao.getQuestions();
    }
}
