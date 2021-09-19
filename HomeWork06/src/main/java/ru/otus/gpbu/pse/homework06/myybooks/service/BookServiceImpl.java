package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.repository.BookRepository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;
import ru.otus.gpbu.pse.homework06.myybooks.models.ModelsObjectFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    @Transactional
    public Optional<Book> getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    @Transactional
    public long insert(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    @Transactional
    public long insert(String name, Long genre_id, Long author_id) {
        return this.insert(
                ModelsObjectFactory.getBook(
                        name,
                        genreService.getById(genre_id).get(),
                        authorService.getById(author_id).get()));
    }

    @Override
    @Transactional
    public void update(Book book) {
        bookRepository.update(book);
    }

    @Override
    @Transactional
    public void update(Long id, String name, Long genre_id, Long author_id) {
        this.update(ModelsObjectFactory.getBook(
                id, name,
                genreService.getById(genre_id).get(),
                authorService.getById(author_id).get()));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public long count() {
        return bookRepository.count();
    }
}
