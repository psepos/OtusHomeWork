package ru.otus.gpbu.pse.homework09.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book insert(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

}
