package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.domain.ObjectFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper2 implements RowMapper<Book> {


    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Genre genre = ObjectFactory.getGenre(
                resultSet.getLong("genre_id"),
                resultSet.getString("genre_name"));

        Author author = ObjectFactory.getAuthor(
                resultSet.getLong("author_id"),
                resultSet.getString("author_name"));

        return new Book(
                resultSet.getLong("book_id"),
                resultSet.getString("book_name"),
                genre,
                author);

    }
}
