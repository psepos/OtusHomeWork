package ru.otus.gpbu.pse.homework05.myybooks.repository;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.List;

public interface AuthorDao {
    Author getById(long id);

    long insert(Author author);

    void update(Author author);

    void deleteById(long id);

    List<Author> getAll();

    int count();
}
