package ru.otus.gpbu.pse.homework06.mybooks.genre.service;

import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(long id);

    long insert(Genre genre);

    long insert(String name);

    long insert(Long id, String name);

    long update(Genre genre);

    long update(Long id, String name);

    long deleteById(long id);

    List<Genre> getAll();

    long count();
}
