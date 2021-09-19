package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.repository.GenreRepository;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository dao) {
        this.genreRepository = dao;
    }

    @Override
    public Genre getById(long id) {
        return genreRepository.getById(id);
    }

    @Override
    public long insert(Genre genre) {
        return genreRepository.insert(genre);
    }

    @Override
    public long insert(String name) {
        return this.insert(DomainObjectFactory.getGenre(name));
    }

    @Override
    public void insert(Long id, String name) {
        this.insert(DomainObjectFactory.getGenre(name));
    }

    @Override
    public void update(Genre genre) {
        genreRepository.update(genre);
    }

    @Override
    public void update(Long id, String name) {
        this.update(DomainObjectFactory.getGenre(id, name));
    }

    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public int count() {
        return genreRepository.count();
    }
}
