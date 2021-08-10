package ru.otus.gpbu.pse.homework03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework03.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsServiceSimple;

@Configuration
public class ServiceConfig {

    @Bean
    GetQuestionsService getQuestionsService(GetQuestionsDao dao) {
        return new GetQuestionsServiceSimple(dao);
    }
}
