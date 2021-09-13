package ru.otus.gpbu.pse.homework06.myybooks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.myybooks.dao.mappers.AuthorMapper;
import ru.otus.gpbu.pse.homework06.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework06.myybooks.domain.Author;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;
    private final AuthorMapper authorMapper;
    private final IntegerMapper integerMapper;

    @Autowired
    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorMapper authorMapper, IntegerMapper integerMapper) {
        this.jdbc = jdbcOperations;
        this.authorMapper = authorMapper;
        this.integerMapper = integerMapper;
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);

        try {
            return jdbc.queryForObject("SELECT * FROM author WHERE id = :id", params, authorMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new DoesNotExistException("Author does not exists", e);
        }
    }

    @Override
    public long insert(Author author) {

        SqlParameterSource params = new MapSqlParameterSource().addValue("name", author.name());
        KeyHolder kh = new GeneratedKeyHolder();
        var sql = "INSERT INTO author (name) VALUES (:name)";
        jdbc.update(sql, params, kh);
        author.id(Objects.requireNonNull(kh.getKey()).longValue());

        return author.id();
    }

    @Override
    public void update(Author author) {
        var map = Map.of("id", author.id(), "name", author.name());
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
        return jdbc.query("SELECT * FROM author", authorMapper);
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM author", integerMapper.setColumnLabel("Count")).get(0);
    }
}
