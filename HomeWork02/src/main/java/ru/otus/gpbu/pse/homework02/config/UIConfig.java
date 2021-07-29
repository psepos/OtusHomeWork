package ru.otus.gpbu.pse.homework02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsConsoleUI;
import ru.otus.gpbu.pse.homework02.ui.MyQuestionsUI;

@Configuration
public class UIConfig {

    @Bean
    MyQuestionsUI myQuestionsUI() {
        return new MyQuestionsConsoleUI();
    }

}
