package ru.otus.gpbu.pse.homework04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework04.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework04.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework04.service.GetQuestionsServiceSimple;

@Configuration
public class ServiceConfig {

    @Bean
    GetQuestionsService getQuestionsService(GetQuestionsDao dao) {
        return new GetQuestionsServiceSimple(dao);
    }
}
