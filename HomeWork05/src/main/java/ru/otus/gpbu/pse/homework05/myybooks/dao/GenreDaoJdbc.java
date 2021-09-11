package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.GenreMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;
    private final GenreMapper genreMapper;
    private final IntegerMapper integerMapper;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbcOperations, GenreMapper genreMapper, IntegerMapper integerMapper) {
        this.jdbc = jdbcOperations;
        this.genreMapper = genreMapper;
        this.integerMapper = integerMapper;
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {
            return jdbc.queryForObject("SELECT * FROM genre WHERE id = :id", params, genreMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new DoesNotExistException("Genre does not exists", e);
        }
    }

    @Override
    public long insert(Genre genre) {
        SqlParameterSource params = new MapSqlParameterSource().addValue("name", genre.name());
        var sql = "INSERT INTO genre (name) VALUES (:name)";
        KeyHolder kh = new GeneratedKeyHolder();
        jdbc.update(sql, params, kh);
        genre.id(kh.getKey().longValue());
        return genre.id();
    }

    @Override
    public void update(Genre genre) {
        var map = Map.of("id", genre.id(), "name", genre.name());
        var sql = "UPDATE genre SET name = :name WHERE id = :id";
        jdbc.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("DELETE FROM genre WHERE id = :id", params);
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("SELECT * FROM genre", genreMapper);
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM genre", integerMapper.setColumnLabel("Count")).get(0);
    }
}
