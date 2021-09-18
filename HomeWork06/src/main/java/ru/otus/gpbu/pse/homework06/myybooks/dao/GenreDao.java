package ru.otus.gpbu.pse.homework06.myybooks.dao;

import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);

    long insert(Genre genre);

    void update(Genre genre);

    void deleteById(long id);

    List<Genre> getAll();

    int count();
}
