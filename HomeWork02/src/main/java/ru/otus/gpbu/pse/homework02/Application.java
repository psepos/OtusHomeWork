package ru.otus.gpbu.pse.homework02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.gpbu.pse.homework02.config.AppConfig;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionController;

public class Application {

    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyQuestionController controller = context.getBean(MyQuestionController.class);
        controller.run();
    }
}
