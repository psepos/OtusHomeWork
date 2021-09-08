package ru.otus.gpbu.pse.homework05.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework05.myybooks.dao.BookDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookDao dao;

    public BookServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public Book getById(long id) {
        return dao.getById(id);
    }

    @Override
    public void insert(Book book) {
        dao.insert(book);
    }

    @Override
    public void update(Book book) {
        dao.update(book);
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
    public List<Book> getAll2() {
        return dao.getAll2();
    }

    @Override
    public int count() {
        return dao.count();
    }
}
