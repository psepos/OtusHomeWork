package ru.otus.gpbu.pse.homework02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework02.ui.MyStudentTestUIConsole;
import ru.otus.gpbu.pse.homework02.ui.MyStudentTestUI;

@Configuration
public class UIConfig {

    @Bean
    MyStudentTestUI myQuestionsUI() {
        return new MyStudentTestUIConsole();
    }

}
