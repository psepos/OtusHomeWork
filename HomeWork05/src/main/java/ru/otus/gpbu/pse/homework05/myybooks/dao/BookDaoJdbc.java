package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.BookMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.BookMapper2;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapperImpl;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao{

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final BookMapper bookMapper;
    private final BookMapper2 bookMapper2;
    private final IntegerMapper integerMapper;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations, BookMapper bookMapper, BookMapper2 bookMapper2, IntegerMapper integerMapper) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
        this.bookMapper = bookMapper;
        this.bookMapper2 = bookMapper2;
        this.integerMapper = integerMapper;
    }


    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        String sql = "SELECT * FROM book WHERE id = :id";

        return namedParameterJdbcOperations.queryForObject(sql, params, bookMapper);
    }

    @Override
    public Book getById2(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);

        String sql = "SELECT b.id   AS book_id, " +
                            "b.name AS book_name, " +
                            "g.id   AS genre_id, " +
                            "g.name AS genre_name, " +
                            "a.id   AS author_id, " +
                            "a.name AS author_name " +
                        "FROM book b " +
                        "LEFT JOIN genre g  ON g.id = b.genre_id " +
                        "LEFT JOIN author a ON a.id = b.author_id " +
                        "WHERE b.id = :id";
        return namedParameterJdbcOperations.queryForObject(sql, params, bookMapper2);
    }

    @Override
    public void insert(Book book) {
        var map = Map.of(
                "id",book.getId(),
                "name",book.getName(),
                "genre_id",book.getGenre().getId(),
                "author_id",book.getAuthor().getId());
        var sql = "INSERT INTO book (id, name, genre_id, author_id) " +
                  "VALUES (:id, :name, :genre_id, :author_id)";
        namedParameterJdbcOperations.update(sql, map);
    }

    @Override
    public void update(Book book) {
        var map = Map.of(
                "id",book.getId(),
                "name",book.getName(),
                "genre_id",book.getGenre().getId(),
                "author_id",book.getAuthor().getId());

        var sql = "UPDATE book SET name = :name, genre_id = :genre_id, author_id = :author_id WHERE id = :id";
        namedParameterJdbcOperations.update(sql, map);
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update("DELETE FROM book WHERE id = :id", params);
    }

    @Override
    public List<Book> getAll() {
         return namedParameterJdbcOperations.query("SELECT * FROM book", bookMapper);
    }

    @Override
    public List<Book> getAll2() {
        String sql = "SELECT b.id   AS book_id, " +
                            "b.name AS book_name, " +
                            "g.id   AS genre_id, " +
                            "g.name AS genre_name, " +
                            "a.id   AS author_id, " +
                            "a.name AS author_name " +
                       "FROM book b " +
                       "LEFT JOIN genre g  ON g.id = b.genre_id " +
                       "LEFT JOIN author a ON a.id = b.author_id ";
        return namedParameterJdbcOperations.query(sql, bookMapper2);
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.query("SELECT count(*) AS Count FROM BOOK", integerMapper.setColumnLabel("Count")).get(0);
    }
}
