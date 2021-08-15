package ru.otus.gpbu.pse.homework03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework03.controller.MyStudentTestController;
import ru.otus.gpbu.pse.homework03.controller.MyStudentTestControllerMain;
import ru.otus.gpbu.pse.homework03.service.GetQuestionsService;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;

@Configuration
public class MyStudentTestControllerConfig {

    @Autowired
    private YEnvironment environment;

    @Bean
    MyStudentTestController myQuestionController(GetQuestionsService service,
                                                 MyStudentTestUI ui) {
        return new MyStudentTestControllerMain(service, ui, environment.getPassingScore());
    }

}
