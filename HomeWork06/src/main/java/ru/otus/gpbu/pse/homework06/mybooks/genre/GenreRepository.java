package ru.otus.gpbu.pse.homework06.mybooks.genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> getById(long id);

    long insert(Genre genre);

    void update(Genre genre);

    long deleteById(long id);

    List<Genre> getAll();

    long count();
}
