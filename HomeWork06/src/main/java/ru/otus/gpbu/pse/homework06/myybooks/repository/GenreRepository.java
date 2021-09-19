package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> getById(long id);

    long insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    List<Genre> getAll();

    int count();
}
