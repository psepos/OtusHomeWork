package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.List;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public Author getById(long id) {
        return null;
    }

    @Override
    public Author insert(Author author) {
        return null;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public Author deleteById(long id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM AUTHOR", new IntegerMapper("Count")).get(0);
    }
}
