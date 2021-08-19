package ru.otus.gpbu.pse.homework03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.gpbu.pse.homework03.MyStudent.controller.MyStudentTestController;

@SpringBootApplication
@ComponentScan("ru.otus.gpbu.pse.homework03.MyStudent")
public class Homework03Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Homework03Application.class, args);
		MyStudentTestController controller = ctx.getBean(MyStudentTestController.class);
		controller.run();
	}

}
