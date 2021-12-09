package ru.otus.gpbu.pse.homework10.mybooks.genre.service;


import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework10.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework10.mybooks.genre.repository.GenreRepository;

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
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
