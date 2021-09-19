package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.repository.BookRepository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository dao, GenreService genreService, AuthorService authorService) {
        this.bookRepository = dao;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    @Override
    public Book getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public long insert(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public long insert(String name, Long genre_id, Long author_id) {
        return this.insert(
                DomainObjectFactory.getBook(
                        name,
                        genreService.getById(genre_id),
                        authorService.getById(author_id)));
    }

    @Override
    public void update(Book book) {
        bookRepository.update(book);
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
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public int count() {
        return bookRepository.count();
    }
}
