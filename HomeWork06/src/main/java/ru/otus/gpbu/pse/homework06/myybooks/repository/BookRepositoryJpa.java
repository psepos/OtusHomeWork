package ru.otus.gpbu.pse.homework06.myybooks.repository;

import ru.otus.gpbu.pse.homework06.myybooks.models.Book;

import java.util.List;
import java.util.Optional;

public class BookRepositoryJpa implements BookRepository{
    @Override
    public Optional<Book> getById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Book book) {
        return 0;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
