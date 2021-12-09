package ru.otus.gpbu.pse.homework10.mybooks.genre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework10.mybooks.genre.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
