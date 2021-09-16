package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.BookMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;
    private final BookMapper bookMapper;
    private final IntegerMapper integerMapper;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc, BookMapper bookMapper, IntegerMapper integerMapper) {
        this.jdbc = jdbc;
        this.bookMapper = bookMapper;
        this.integerMapper = integerMapper;
    }


    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);

        String sql = "SELECT b.id AS book_id, " +
                "b.name AS book_name, " +
                "g.id   AS genre_id, " +
                "g.name AS genre_name, " +
                "a.id   AS author_id, " +
                "a.name AS author_name " +
                "FROM book b " +
                "LEFT JOIN genre g  ON g.id = b.genre_id " +
                "LEFT JOIN author a ON a.id = b.author_id " +
                "WHERE b.id = :id";
        try {
            return jdbc.queryForObject(sql, params, bookMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new DoesNotExistException("Does not exists", e);
        }
    }

    @Override
    public long insert(Book book) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", book.name())
                .addValue("genre_id", book.genre().id())
                .addValue("author_id", book.author().id());
        KeyHolder kh = new GeneratedKeyHolder();

        var sql = "INSERT INTO book (name, genre_id, author_id) " +
                "VALUES (:name, :genre_id, :author_id)";
        jdbc.update(sql, params, kh);
        book.id(Objects.requireNonNull(kh.getKey()).longValue());
        return book.id();
    }

    @Override
    public void update(Book book) {
        var map = Map.of(
                "id", book.id(),
                "name", book.name(),
                "genre_id", book.genre().id(),
                "author_id", book.author().id());

        var sql = "UPDATE book SET name = :name, genre_id = :genre_id, author_id = :author_id WHERE id = :id";
        jdbc.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("DELETE FROM book WHERE id = :id", params);
    }

    @Override
    public List<Book> getAll() {
        String sql = "SELECT b.id   AS book_id, " +
                "b.name AS book_name, " +
                "g.id   AS genre_id, " +
                "g.name AS genre_name, " +
                "a.id   AS author_id, " +
                "a.name AS author_name " +
                "FROM book b " +
                "LEFT JOIN genre g  ON g.id = b.genre_id " +
                "LEFT JOIN author a ON a.id = b.author_id ";
        return jdbc.query(sql, bookMapper);
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM BOOK", integerMapper.setColumnLabel("Count")).get(0);
    }
}
