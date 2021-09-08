package ru.otus.gpbu.pse.homework05.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao dao;

    public AuthorServiceImpl(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public Author getById(long id) {
        return dao.getById(id);
    }

    @Override
    public void insert(Author author) {
        dao.insert(author);
    }

    @Override
    public void update(Author author) {
        dao.update(author);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return dao.getAll();
    }

    @Override
    public int count() {
        return dao.count();
    }
}
