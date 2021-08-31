package ru.otus.gpbu.pse.homework04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@ComponentScan("ru.otus.gpbu.pse.homework04.test")
@ComponentScan("ru.otus.gpbu.pse.homework04.MyStudent.statemachine.config.StateMachineConfig")
@ComponentScan("ru.otus.gpbu.pse.homework04.MyStudent.statemachine")

class Homework04ApplicationTests {

	@Test
	void contextLoads() {
	}

}
