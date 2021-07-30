package ru.otus.gpbu.pse.homework02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.gpbu.pse.homework02.dao.GetQuestionsDao;
import ru.otus.gpbu.pse.homework02.dao.GetQuestionsFromCsvDao;

@Configuration
@PropertySource("classpath:application.properties")
public class DaoConfig {
    @Bean
    GetQuestionsDao getQuestionsDao(@Value("${csv.file}") String csvFile,
                                    @Value("${csv.delimiter}") String csvDelimiter) {
        return new GetQuestionsFromCsvDao(csvFile, csvDelimiter);
    }
}
