package ru.otus.gpbu.pse.homework06.mybooks.book.repository;

import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> getById(long id);
    long insert(Book book);
    long update(Book book);
    long deleteById(long id);
    List<Book> getAll();
    long count();
}
