package ru.otus.gpbu.pse.homework08.mybooks.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
