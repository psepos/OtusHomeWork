package ru.otus.gpbu.pse.homework08.mybooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HomeWork08Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork08Application.class, args);
    }

}
