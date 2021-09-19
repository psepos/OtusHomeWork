package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> getById(long id);
    long insert(Book book);
    void update(Book book);
    long deleteById(long id);
    List<Book> getAll();

    long count();

}
