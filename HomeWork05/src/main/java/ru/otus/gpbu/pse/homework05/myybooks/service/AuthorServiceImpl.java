package ru.otus.gpbu.pse.homework05.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework05.myybooks.dao.AuthorDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    public AuthorServiceImpl(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public Author getById(long id) {
        return dao.getById(id);
    }

    @Override
    public long insert(Author author) {
        return dao.insert(author);
    }

    @Override
    public long insert(String name) {
        return this.insert(DomainObjectFactory.getAuthor(0l, name));
    }

    @Override
    public void update(Author author) {
        dao.update(author);
    }

    @Override
    public void update(Long id, String name) {
        this.update(DomainObjectFactory.getAuthor(id, name));
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
