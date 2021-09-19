package ru.otus.gpbu.pse.homework06.myybooks.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;

import java.util.List;
import java.util.Optional;

@Repository
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
    public long deleteById(long id) {
        return 0;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
