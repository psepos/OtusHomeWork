package ru.otus.gpbu.pse.homework08.mybooks.author;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
