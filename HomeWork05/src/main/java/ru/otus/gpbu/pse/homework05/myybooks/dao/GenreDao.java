package ru.otus.gpbu.pse.homework05.myybooks.dao;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);
    Genre insert(Genre genre);
    Genre update(Genre genre);
    Genre deleteById(long id);

    List<Genre> getAll();

    int count();
}
