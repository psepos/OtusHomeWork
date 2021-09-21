package ru.otus.gpbu.pse.homework06.mybooks.author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Optional<Author> getById(long id);

    long insert(Author author);

    void update(Author author);

    long deleteById(long id);

    List<Author> getAll();

    long count();
}
