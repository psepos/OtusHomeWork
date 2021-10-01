package ru.otus.gpbu.pse.homework07.mybooks.genre.service;

import ru.otus.gpbu.pse.homework07.mybooks.genre.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(long id);

    Genre insert(Genre genre);

    Genre insert(String name);

    Genre insert(Long id, String name);

    Genre update(Genre genre);

    Genre update(Long id, String name);

    void deleteById(long id);

    List<Genre> getAll();

    long count();
}
