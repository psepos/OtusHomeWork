package ru.otus.gpbu.pse.homework05.myybooks.dao;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

public interface BookDao {
    Book getById(long id);
    Book getById2(long id);
    void insert(Book book);
    void update(Book book);
    void deleteById(long id);

    List<Book> getAll();
    List<Book> getAll2();

    int count();

}
