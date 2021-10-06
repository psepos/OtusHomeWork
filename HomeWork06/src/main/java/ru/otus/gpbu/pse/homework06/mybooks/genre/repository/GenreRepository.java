package ru.otus.gpbu.pse.homework06.mybooks.genre.repository;

import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> getById(long id);
    long insert(Genre genre);
    long update(Genre genre);
    long delete(Genre genre);
    List<Genre> getAll();
    long count();
}
