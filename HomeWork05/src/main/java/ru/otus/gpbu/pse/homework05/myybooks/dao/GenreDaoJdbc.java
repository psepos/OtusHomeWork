package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.GenreMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao{

    private final NamedParameterJdbcOperations jdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject("SELECT * FROM genre WHERE id = :id", params, new GenreMapper());
    }

    @Override
    public void insert(Genre genre) {
        var map = Map.of("id",genre.getId(),"name",genre.getName());
        var sql = "INSERT INTO genre (id, name) VALUES (:id, :name)";
        jdbc.update(sql, map);
    }

    @Override
    public void update(Genre genre) {
        var map = Map.of("id",genre.getId(),"name",genre.getName());
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
        return jdbc.query("SELECT * FROM genre", new GenreMapper());
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM genre", new IntegerMapper("Count")).get(0);
    }
}
