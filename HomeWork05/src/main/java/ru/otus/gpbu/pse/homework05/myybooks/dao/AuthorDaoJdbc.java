package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.AuthorMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapperImpl;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final AuthorMapper authorMapper;
    private final IntegerMapper integerMapper;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorMapper authorMapper, IntegerMapper integerMapper) {
        this.jdbcOperations = jdbcOperations;
        this.authorMapper = authorMapper;
        this.integerMapper = integerMapper;
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("SELECT * FROM author WHERE id = :id", params, authorMapper);
    }

    @Override
    public void insert(Author author) {
        var map = Map.of("id", author.getId(), "name", author.getName());
        var sql = "INSERT INTO author (id, name) VALUES (:id, :name)";
        jdbcOperations.update(sql, map);
    }

    @Override
    public void update(Author author) {
        var map = Map.of("id", author.getId(), "name", author.getName());
        var sql = "UPDATE author SET name = :name WHERE id = :id";
        jdbcOperations.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update("DELETE FROM author WHERE id = :id", params);
    }

    @Override
    public List<Author> getAll() {
        return jdbcOperations.query("SELECT * FROM author", authorMapper);
    }

    @Override
    public int count() {
        return jdbcOperations.query("SELECT count(*) AS Count FROM author", integerMapper.setColumnLabel("Count")).get(0);
    }
}
