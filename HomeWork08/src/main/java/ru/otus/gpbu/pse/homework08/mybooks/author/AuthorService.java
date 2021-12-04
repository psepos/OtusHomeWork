package ru.otus.gpbu.pse.homework08.mybooks.author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> find(Author author);
    List<Author> findAll();
    Author save(Author author);
    void delete(Author author);
}
