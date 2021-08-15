package ru.otus.gpbu.pse.homework03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework03.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework03.dao.GetQuestionsDaoFromCsv;

@Configuration
public class DaoConfig {

    @Autowired
    private YAMLEnvironment environment;

    @Bean
    GetQuestionsDao getQuestionsDao() {
        return new GetQuestionsDaoFromCsv(environment.getCsvFile(), environment.getCsvDelimiter());
    }
}
