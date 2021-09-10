package ru.otus.gpbu.pse.homework05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@SpringBootApplication
public class Homework05Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Homework05Application.class, args);

	}

}
