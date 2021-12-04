package ru.otus.gpbu.pse.homework08.mybooks.book;


import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> find(Book book);
    Book save(Book book);
    void delete(Book book);
    List<Book> findAll();
    Book refresh(Book book);
    Book addGenre(Book book, String genreId);
}
