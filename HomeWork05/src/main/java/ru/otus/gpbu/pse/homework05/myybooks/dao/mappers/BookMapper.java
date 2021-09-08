package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    public BookMapper(GenreDao genreDao, AuthorDao authorDao) {
        this.genreDao = genreDao;
        this.authorDao = authorDao;
    }

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        return new Book(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                genreDao.getById(resultSet.getLong("genre_id")),
                authorDao.getById(resultSet.getLong("author_id")));
    }
}
