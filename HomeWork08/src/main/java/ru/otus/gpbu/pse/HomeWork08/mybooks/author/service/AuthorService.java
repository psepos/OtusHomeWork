package ru.otus.gpbu.pse.homework08.mybooks.author.service;

import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> getById(long id);

    long insert(Author author);

    long insert(String name);

    void update(Author author);

    void update(Long id, String name);

    long deleteById(long id);

    List<Author> getAll();

    long count();
}
