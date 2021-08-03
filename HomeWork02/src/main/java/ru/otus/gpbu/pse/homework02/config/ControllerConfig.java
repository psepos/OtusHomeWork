package ru.otus.gpbu.pse.homework02.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.gpbu.pse.homework02.controller.MyStudentTestController;
import ru.otus.gpbu.pse.homework02.controller.MyStudentTestControllerMain;
import ru.otus.gpbu.pse.homework02.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework02.ui.MyStudentTestUI;

@PropertySource("classpath:application.properties")
@Configuration
public class ControllerConfig {

    @Bean
    MyStudentTestController myQuestionController(GetQuestionsService service,
                                                 MyStudentTestUI ui,
                                                 @Value("${app.passingScore}") String passingScore) {
        return new MyStudentTestControllerMain(service, ui, passingScore);
    }

}
