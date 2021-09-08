package ru.otus.gpbu.pse.homework05.myybooks.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.BookMapper;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.BookMapper2;
import ru.otus.gpbu.pse.homework05.myybooks.dao.mappers.IntegerMapper;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao{

    private final NamedParameterJdbcOperations jdbc;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc, GenreDao genreDao, AuthorDao authorDao) {
        this.jdbc = jdbc;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
    }

    @Override
    public Book getById(long id) {
        return null;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbc.update("DELETE FROM book WHERE id = :id", params);
    }

    @Override
    public List<Book> getAll() {
         return jdbc.query("SELECT * FROM book", new BookMapper(genreDao, authorDao));
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
                       "INNER JOIN genre g  ON g.id = b.genre_id " +
                       "INNER JOIN author a ON a.id = b.author_id ";
        return jdbc.query(sql, new BookMapper2());
    }

    @Override
    public int count() {
        return jdbc.query("SELECT count(*) AS Count FROM BOOK", new IntegerMapper("Count")).get(0);
    }
}
