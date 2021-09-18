package ru.otus.gpbu.pse.homework06.myybooks.dao.mappers;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return DomainObjectFactory.getGenre(id, name);
    }
}
