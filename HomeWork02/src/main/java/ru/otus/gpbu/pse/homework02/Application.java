package ru.otus.gpbu.pse.homework02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.gpbu.pse.homework02.config.AppConfig;
import ru.otus.gpbu.pse.homework02.controller.MyStudentTestController;

public class Application {

    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyStudentTestController controller = context.getBean(MyStudentTestController.class);
        controller.run();
    }
}
