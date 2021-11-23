package ru.otus.gpbu.pse.homework08.mybooks.book;


import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(String bookId);
    Book save(Book book);
    void deleteById(String bookId);
    void delete(Book book);
    List<Book> findAll();
}
