package ru.otus.gpbu.pse.homework10.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework10.mybooks.book.Book;
import ru.otus.gpbu.pse.homework10.mybooks.book.repository.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final EntityManager em;

    public BookServiceImpl(BookRepository bookRepository, EntityManager em) {
        this.bookRepository = bookRepository;
        this.em = em;
    }

    @Override
    public Optional<Book> findById(long id) {
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
