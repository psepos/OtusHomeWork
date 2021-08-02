package ru.otus.gpbu.pse.homework02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionController;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionControllerMain;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

@PropertySource("classpath:application.properties")
@Configuration
public class ControllerConfig {

    @Bean
    MyQuestionController myQuestionController(GetQuestionsService service,
                                              MyQuestionsUI ui,
                                              @Value("${app.numberOfCorrectAnswersToEnd}") String numberOfCorrectAnswersToEnd) {
        return new MyQuestionControllerMain(service, ui, numberOfCorrectAnswersToEnd);
    }

}
