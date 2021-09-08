package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao{

    private final NamedParameterJdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(long id) {
        return null;
    }

    @Override
    public void insert(Book book) {

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
        return jdbc.query("SELECT count(*) AS Count FROM BOOK", new IntegerMapper("Count")).get(0);
    }
}
