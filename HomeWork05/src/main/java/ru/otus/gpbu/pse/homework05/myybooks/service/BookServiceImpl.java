package ru.otus.gpbu.pse.homework05.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework05.myybooks.dao.BookDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;
    private final GenreService genreService;
    private final AuthorService authorService;

    public BookServiceImpl(BookDao dao, GenreService genreService, AuthorService authorService) {
        this.dao = dao;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public Book getById(long id) {
        return dao.getById(id);
    }

    @Override
    public long insert(Book book) {
        return dao.insert(book);
    }

    @Override
    public long insert(String name, Long genre_id, Long author_id) {
        return this.insert(
                DomainObjectFactory.getBook(
                        0l, name,
                        genreService.getById(genre_id),
                        authorService.getById(author_id)));
    }

    @Override
    public void update(Book book) {
        dao.update(book);
    }

    @Override
    public void update(Long id, String name, Long genre_id, Long author_id) {
        this.update(DomainObjectFactory.getBook(
                id, name,
                genreService.getById(genre_id),
                authorService.getById(author_id)));
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return dao.getAll();
    }

    @Override
    public int count() {
        return dao.count();
    }
}
