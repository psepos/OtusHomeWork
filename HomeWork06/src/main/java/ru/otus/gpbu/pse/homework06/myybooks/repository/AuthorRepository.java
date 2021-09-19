package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Optional<Author> getById(long id);

    long insert(Author author);

    void update(Author author);

    void deleteById(long id);

    List<Author> getAll();

    int count();
}
