package ru.otus.gpbu.pse.homework06.myybooks.service;

import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);

    long insert(Genre genre);

    long insert(String name);

    void insert(Long id, String name);

    void update(Genre genre);

    void update(Long id, String name);

    void deleteById(long id);

    List<Genre> getAll();

    int count();
}
