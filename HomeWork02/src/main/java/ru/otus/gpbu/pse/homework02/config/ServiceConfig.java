package ru.otus.gpbu.pse.homework02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework02.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsServiceSimple;

@Configuration
public class ServiceConfig {

    @Bean
    GetQuestionsService getQuestionsService(GetQuestionsDao dao) {
        return new GetQuestionsServiceSimple(dao);
    }
}
