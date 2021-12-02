package ru.otus.gpbu.pse.homework09.mybooks.author.service;

import ru.otus.gpbu.pse.homework09.mybooks.author.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> getById(long id);

    Author insert(Author author);

    Author update(Author author);

    void deleteById(long id);

    List<Author> getAll();

}
