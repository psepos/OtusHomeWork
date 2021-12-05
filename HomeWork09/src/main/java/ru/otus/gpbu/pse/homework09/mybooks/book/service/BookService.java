package ru.otus.gpbu.pse.homework09.mybooks.book.service;


import ru.otus.gpbu.pse.homework09.mybooks.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(long id);
    Book insert(Book book);
    Book update(Book book);
    void deleteById(long id);
    List<Book> getAll();
}
