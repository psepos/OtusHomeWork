package ru.otus.gpbu.pse.homework05.myybooks.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        return null;
    }
}
