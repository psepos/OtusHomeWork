package ru.otus.gpbu.pse.homework05.myybooks.repository;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);

    long insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    List<Genre> getAll();

    int count();
}
