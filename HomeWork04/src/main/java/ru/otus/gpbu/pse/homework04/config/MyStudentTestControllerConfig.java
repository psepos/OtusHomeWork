package ru.otus.gpbu.pse.homework04.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework04.controller.MyStudentTestController;
import ru.otus.gpbu.pse.homework04.controller.MyStudentTestControllerMain;
import ru.otus.gpbu.pse.homework04.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework04.ui.MyStudentTestUI;

@Configuration
public class MyStudentTestControllerConfig {

    @Autowired
    private Environment environment;

    @Bean
    MyStudentTestController myQuestionController(GetQuestionsService service,
                                                 MyStudentTestUI ui,
                                                 MessageSource messageSource) {

        return new MyStudentTestControllerMain(service, ui, messageSource, environment);
    }

}
