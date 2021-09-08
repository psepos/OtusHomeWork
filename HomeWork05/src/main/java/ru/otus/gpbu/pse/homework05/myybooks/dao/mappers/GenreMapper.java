package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Genre(id, name);
    }
}
