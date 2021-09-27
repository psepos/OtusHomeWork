package ru.otus.gpbu.pse.homework07.mybooks.genre.service;


import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework07.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework07.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework07.mybooks.genre.repository.GenreRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository dao) {
        this.genreRepository = dao;
    }

    @Override
    @Transactional
    public Optional<Genre> getById(long id) {
        return genreRepository.getById(id);
    }

    @Override
    @Transactional
    public long insert(Genre genre) {
        return genreRepository.insert(genre);
    }

    @Override
    @Transactional
    public long insert(String name) {
        return this.insert(ModelsObjectFactory.getGenre(name));
    }

    @Override
    @Transactional
    public long insert(Long id, String name) {
        return this.insert(ModelsObjectFactory.getGenre(name));
    }

    @Override
    @Transactional
    public long update(Genre genre) {
        return genreRepository.update(genre);
    }

    @Override
    @Transactional
    public long update(Long id, String name) {
        return this.update(ModelsObjectFactory.getGenre(id, name));
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        return genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public long count() {
        return genreRepository.count();
    }
}
