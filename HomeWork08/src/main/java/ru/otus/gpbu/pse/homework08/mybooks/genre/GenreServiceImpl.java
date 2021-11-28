package ru.otus.gpbu.pse.homework08.mybooks.genre;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.service.TriggerService;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final TriggerService triggerService;

    public GenreServiceImpl(GenreRepository genreRepository, TriggerService triggerService) {
        this.genreRepository = genreRepository;
        this.triggerService = triggerService;
    }

    @Override
    public Optional<Genre> find(Genre genre) {
        return genreRepository.findById(genre.getId());
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAll(List<String> ids) {
        return (List<Genre>) genreRepository.findAllById(ids);
    }

    @Override
    public Genre save(Genre genre) {
        triggerService.setLastUpdate(genre);
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }
}
