package ru.otus.gpbu.pse.homework04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework04.ui.MyStudentTestUI;
import ru.otus.gpbu.pse.homework04.ui.MyStudentTestUIConsole;

@Configuration
public class UIConfig {

    @Bean
    MyStudentTestUI myQuestionsUI() {
        return new MyStudentTestUIConsole();
    }

}
