package ru.otus.gpbu.pse.homework03.MyStudent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework03.MyStudent.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework03.MyStudent.domain.Question;

import java.util.List;

@Service
public class GetQuestionsServiceSimple implements GetQuestionsService {

    @Autowired
    private final GetQuestionsDao dao;

    public GetQuestionsServiceSimple(GetQuestionsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getQuestions() {

        return dao.getQuestions();
    }
}
