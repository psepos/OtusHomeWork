package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.AuthorMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject("SELECT * FROM author WHERE id = :id", params, new AuthorMapper());
    }

    @Override
    public void insert(Author author) {
        var map = Map.of("id", author.getId(), "name", author.getName());
        var sql = "INSERT INTO author (id, name) VALUES (:id, :name)";
        jdbc.update(sql, map);
    }

    @Override
    public void update(Author author) {
        var map = Map.of("id", author.getId(), "name", author.getName());
        var sql = "UPDATE author SET name = :name WHERE id = :id";
        jdbc.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("DELETE FROM author WHERE id = :id", params);
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("SELECT * FROM author", new AuthorMapper());
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM author", new IntegerMapper("Count")).get(0);
    }
}
