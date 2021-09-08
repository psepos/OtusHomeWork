package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.GenreMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapperImpl;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao{

    private final NamedParameterJdbcOperations jdbcOperations;
    private final GenreMapper genreMapper;
    private final IntegerMapper integerMapper;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbcOperations, GenreMapper genreMapper, IntegerMapper integerMapper) {
        this.jdbcOperations = jdbcOperations;
        this.genreMapper = genreMapper;
        this.integerMapper = integerMapper;
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject("SELECT * FROM genre WHERE id = :id", params, genreMapper);
    }

    @Override
    public void insert(Genre genre) {
        var map = Map.of("id",genre.getId(),"name",genre.getName());
        var sql = "INSERT INTO genre (id, name) VALUES (:id, :name)";
        jdbcOperations.update(sql, map);
    }

    @Override
    public void update(Genre genre) {
        var map = Map.of("id",genre.getId(),"name",genre.getName());
        var sql = "UPDATE genre SET name = :name WHERE id = :id";
        jdbcOperations.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update("DELETE FROM genre WHERE id = :id", params);
    }

    @Override
    public List<Genre> getAll() {
        return jdbcOperations.query("SELECT * FROM genre", genreMapper);
    }

    @Override
    public int count() {
        return jdbcOperations.query("SELECT count(*) AS Count FROM genre", integerMapper.setColumnLabel("Count")).get(0);
    }
}
