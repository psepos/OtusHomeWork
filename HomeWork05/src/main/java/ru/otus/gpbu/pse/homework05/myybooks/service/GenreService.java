package ru.otus.gpbu.pse.homework05.myybooks.service;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);
    void insert(Genre genre);
    void insert(Long id, String name);
    void update(Genre genre);
    void update(Long id, String name);
    void deleteById(long id);

    List<Genre> getAll();

    int count();
}
