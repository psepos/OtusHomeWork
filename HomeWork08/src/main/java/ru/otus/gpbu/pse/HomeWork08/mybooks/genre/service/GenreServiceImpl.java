package ru.otus.gpbu.pse.homework08.mybooks.genre.service;


import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework08.mybooks.genre.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> getById(long id) {
        return genreRepository.findById(id);
    }

    @Override
    public Genre insert(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre insert(String name) {
        return this.insert(ModelsObjectFactory.getGenre(name));
    }

    @Override
    public Genre insert(Long id, String name) {
        return this.insert(ModelsObjectFactory.getGenre(name));
    }

    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre update(Long id, String name) {
        return this.update(ModelsObjectFactory.getGenre(id, name));
    }

    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public long count() {
        return genreRepository.count();
    }
}
