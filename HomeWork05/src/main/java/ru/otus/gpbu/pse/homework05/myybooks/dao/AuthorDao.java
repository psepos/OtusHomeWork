package ru.otus.gpbu.pse.homework05.myybooks.dao;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.List;

public interface AuthorDao {
    Author getById(long id);
    Author insert(Author author);
    Author update(Author author);
    Author deleteById(long id);

    List<Author> getAll();

    int count();
}
