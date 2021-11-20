package ru.otus.gpbu.pse.homework08.mybooks.author.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;

public interface AuthorRepository extends MongoRepository<Author, Long> {

}
