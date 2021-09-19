package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.models.Author;
import ru.otus.gpbu.pse.homework06.myybooks.models.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.repository.AuthorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<Author> getById(long id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public long insert(Author author) {
        return repository.insert(author);
    }

    @Override
    @Transactional
    public long insert(String name) {
        return this.insert(ModelsObjectFactory.getAuthor(name));
    }

    @Override
    @Transactional
    public void update(Author author) {
        repository.update(author);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        this.update(ModelsObjectFactory.getAuthor(id, name));
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return repository.getAll();
    }

    @Override
    public long count() {
        return repository.count();
    }
}
