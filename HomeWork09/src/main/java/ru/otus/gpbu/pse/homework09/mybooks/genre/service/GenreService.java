package ru.otus.gpbu.pse.homework09.mybooks.genre.service;

import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> getById(long id);

    Genre insert(Genre genre);

    Genre update(Genre genre);

    void deleteById(long id);

    List<Genre> getAll();
}
