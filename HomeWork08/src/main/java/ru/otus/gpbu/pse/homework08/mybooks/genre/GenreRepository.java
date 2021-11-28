package ru.otus.gpbu.pse.homework08.mybooks.genre;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
