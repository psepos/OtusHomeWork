package ru.otus.gpbu.pse.homework05.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDao dao;

    public GenreServiceImpl(GenreDao dao) {
        this.dao = dao;
    }

    @Override
    public Genre getById(long id) {
        return dao.getById(id);
    }

    @Override
    public void insert(Genre genre) {
        dao.insert(genre);
    }

    @Override
    public void insert(Long id, String name) {
        this.insert(DomainObjectFactory.getGenre(id, name));
    }

    @Override
    public void update(Genre genre) {
        dao.update(genre);
    }

    @Override
    public void update(Long id, String name) {
        this.update(DomainObjectFactory.getGenre(id, name));
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return dao.getAll();
    }

    @Override
    public int count() {
        return dao.count();
    }
}
