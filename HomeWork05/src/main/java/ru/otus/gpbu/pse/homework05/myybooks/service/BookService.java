package ru.otus.gpbu.pse.homework05.myybooks.service;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

public interface BookService {
    Book getById(long id);
    void insert(Book book);
    void update(Book book);
    void deleteById(long id);

    List<Book> getAll();
    List<Book> getAll2();

    int count();
}
