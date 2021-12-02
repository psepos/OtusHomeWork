package ru.otus.gpbu.pse.homework09.mybooks.author.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.repository.AuthorRepository;

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
    public Author insert(Author author) {
        repository.save(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        repository.save(author);
        return author;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }
}
