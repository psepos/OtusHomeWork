package ru.otus.gpbu.pse.homework05.myybooks.service;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

public interface BookService {

    Book getById(long id);

    void insert(Book book);

    void insert(Long id, String name, Long genre_id, Long author_id);

    void update(Book book);

    void update(Long id, String name, Long genre_id, Long author_id);

    void deleteById(long id);

    List<Book> getAll();

    int count();
}
