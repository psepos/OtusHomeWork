package ru.otus.gpbu.pse.homework07.mybooks.author.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework07.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework07.mybooks.author.repository.AuthorRepository;
import ru.otus.gpbu.pse.homework07.mybooks.common.ModelsObjectFactory;

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
    public Optional<Author> getById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public long insert(Author author) {
        repository.save(author);
        return author.getId();
    }

    @Override
    @Transactional
    public long insert(String name) {
        return this.insert(ModelsObjectFactory.getAuthor(name));
    }

    @Override
    @Transactional
    public void update(Author author) {
        repository.save(author);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        this.update(ModelsObjectFactory.getAuthor(id, name));
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        repository.deleteById(id);
        return 0;
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }
}
