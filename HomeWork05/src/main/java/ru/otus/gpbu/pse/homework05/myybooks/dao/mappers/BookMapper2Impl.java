package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper2Impl implements BookMapper2 {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Genre genre = DomainObjectFactory.getGenre(
                resultSet.getLong("genre_id"),
                resultSet.getString("genre_name"));

        Author author = DomainObjectFactory.getAuthor(
                resultSet.getLong("author_id"),
                resultSet.getString("author_name"));

        return new Book(
                resultSet.getLong("book_id"),
                resultSet.getString("book_name"),
                genre,
                author);

    }
}
