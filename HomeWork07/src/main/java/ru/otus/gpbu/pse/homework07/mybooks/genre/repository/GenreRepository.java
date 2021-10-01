package ru.otus.gpbu.pse.homework07.mybooks.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.gpbu.pse.homework07.mybooks.genre.entity.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>,
                                         JpaRepository<Genre, Long> {

}
