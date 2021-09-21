package ru.otus.gpbu.pse.homework06.mybooks.book;

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
