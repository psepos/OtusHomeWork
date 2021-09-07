package ru.otus.gpbu.pse.homework05.myybooks.dao;

import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

public interface BookDao {
    Book getById(long id);
    Book insert(Book book);
    Book update(Book book);
    Book deleteById(long id);

    List<Book> getAll();

    int count();

}
