package ru.otus.gpbu.pse.homework08.mybooks.genre.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

public interface GenreRepository extends MongoRepository<Genre, Long> {

}
