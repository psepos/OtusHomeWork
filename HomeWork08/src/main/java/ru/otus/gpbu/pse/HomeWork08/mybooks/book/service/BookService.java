package ru.otus.gpbu.pse.homework08.mybooks.book.service;


import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getById(String id);
    Book insert(Book book);
    Book save(Book book);
    void deleteById(String id);
    void delete(Book book);
    List<Book> findAll();
}
