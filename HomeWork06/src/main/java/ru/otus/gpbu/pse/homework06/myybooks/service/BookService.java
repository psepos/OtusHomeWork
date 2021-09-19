package ru.otus.gpbu.pse.homework06.myybooks.service;

import ru.otus.gpbu.pse.homework06.myybooks.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getById(long id);

    long insert(Book book);

    long insert(String name, Long genre_id, Long author_id);

    void update(Book book);

    void update(Long id, String name, Long genre_id, Long author_id);

    void deleteById(long id);

    List<Book> getAll();

    int count();
}
