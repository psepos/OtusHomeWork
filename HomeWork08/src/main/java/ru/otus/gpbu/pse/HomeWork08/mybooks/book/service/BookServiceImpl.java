package ru.otus.gpbu.pse.homework08.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework08.mybooks.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Book insert(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public long count() {
        return 0;
    }
}
