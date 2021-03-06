package ru.otus.gpbu.pse.homework02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.gpbu.pse.homework02.controller.MyQuestionController;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MyQuestionController controller = context.getBean(MyQuestionController.class);
        controller.run();
    }

}
