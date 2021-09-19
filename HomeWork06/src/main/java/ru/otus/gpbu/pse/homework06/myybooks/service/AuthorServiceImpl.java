package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.repository.AuthorRepository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Author;
import ru.otus.gpbu.pse.homework06.myybooks.models.DomainObjectFactory;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository dao) {
        this.authorRepository = dao;
    }

    @Override
    public Author getById(long id) {
        return authorRepository.getById(id);
    }

    @Override
    public long insert(Author author) {
        return authorRepository.insert(author);
    }

    @Override
    public long insert(String name) {
        return this.insert(DomainObjectFactory.getAuthor(0L, name));
    }

    @Override
    public void update(Author author) {
        authorRepository.update(author);
    }

    @Override
    public void update(Long id, String name) {
        this.update(DomainObjectFactory.getAuthor(id, name));
    }

    @Override
    public void deleteById(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public int count() {
        return authorRepository.count();
    }
}
