package ru.otus.gpbu.pse.homework06.myybooks.dao;

import ru.otus.gpbu.pse.homework06.myybooks.domain.Book;

import java.util.List;

public interface BookDao {

    Book getById(long id);
    long insert(Book book);
    void update(Book book);
    void deleteById(long id);
    List<Book> getAll();

    int count();

}
