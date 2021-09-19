package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.util.List;
import java.util.Optional;

public class GenreRepositoryJpa implements GenreRepository{
    @Override
    public Optional<Genre> getById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Genre genre) {
        return 0;
    }

    @Override
    public void update(Genre genre) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
