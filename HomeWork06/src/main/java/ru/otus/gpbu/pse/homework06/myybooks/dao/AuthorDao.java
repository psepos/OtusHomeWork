package ru.otus.gpbu.pse.homework06.myybooks.dao;

import ru.otus.gpbu.pse.homework06.myybooks.models.Author;

import java.util.List;

public interface AuthorDao {
    Author getById(long id);

    long insert(Author author);

    void update(Author author);

    void deleteById(long id);

    List<Author> getAll();

    int count();
}
