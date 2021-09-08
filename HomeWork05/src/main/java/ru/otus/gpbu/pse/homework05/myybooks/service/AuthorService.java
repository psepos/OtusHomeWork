package ru.otus.gpbu.pse.homework05.myybooks.service;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.List;

public interface AuthorService {

    Author getById(long id);
    void insert(Author author);
    void update(Author author);
    void deleteById(long id);

    List<Author> getAll();

    int count();
}
