package ru.otus.gpbu.pse.homework06.myybooks.dao.mappers;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework06.myybooks.models.Author;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Genre genre = DomainObjectFactory.getGenre(
                resultSet.getLong("genre_id"),
                resultSet.getString("genre_name"));

        Author author = DomainObjectFactory.getAuthor(
                resultSet.getLong("author_id"),
                resultSet.getString("author_name"));

        return DomainObjectFactory.getBook(
                resultSet.getLong("book_id"),
                resultSet.getString("book_name"),
                genre,
                author);
    }
}
