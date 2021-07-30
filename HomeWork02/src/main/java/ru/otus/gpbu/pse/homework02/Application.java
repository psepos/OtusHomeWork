package ru.otus.gpbu.pse.homework02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionController;

@ComponentScan
public class Application {

    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MyQuestionController controller = context.getBean(MyQuestionController.class);
        controller.run();
    }
}
