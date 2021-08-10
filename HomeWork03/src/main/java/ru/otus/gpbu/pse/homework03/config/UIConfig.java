package ru.otus.gpbu.pse.homework03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUI;
import ru.otus.gpbu.pse.homework03.ui.MyStudentTestUIConsole;

@Configuration
public class UIConfig {

    @Bean
    MyStudentTestUI myQuestionsUI() {
        return new MyStudentTestUIConsole();
    }

}
