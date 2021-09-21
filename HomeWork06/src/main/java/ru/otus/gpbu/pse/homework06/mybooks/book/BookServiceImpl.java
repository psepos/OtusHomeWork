package ru.otus.gpbu.pse.homework06.mybooks.book;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.author.Author;
import ru.otus.gpbu.pse.homework06.mybooks.author.AuthorService;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework06.mybooks.genre.GenreService;

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
        Optional<Genre> genre = genreService.getById(genre_id);
        if (genre.isEmpty()) {
            return -1;
        }

        Optional<Author> author = authorService.getById(author_id);
        if (author.isEmpty()) {
            return -1;
        }

        return this.insert(ModelsObjectFactory.getBook(name, genre.get(), author.get()));
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
