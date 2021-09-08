package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return new Author(id, name);
    }
}
