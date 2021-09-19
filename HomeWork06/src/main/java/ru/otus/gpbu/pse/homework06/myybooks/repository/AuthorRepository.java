package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Optional<Author> getById(long id);

    long insert(Author author);

    void update(Author author);

    int deleteById(long id);

    List<Author> getAll();

    long count();
}
