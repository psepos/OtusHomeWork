package ru.otus.gpbu.pse.homework06.myybooks.dao.mappers;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework06.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework06.myybooks.domain.DomainObjectFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        return DomainObjectFactory.getAuthor(id, name);
    }
}
