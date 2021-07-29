package ru.otus.gpbu.pse.homework02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionController;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionControllerMain;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

@Configuration
public class ControllerConfig {

    @Bean
    MyQuestionController myQuestionController(GetQuestionsService service,
                                              MyQuestionsUI ui) {
        return new MyQuestionControllerMain(service, ui);
    }

}
