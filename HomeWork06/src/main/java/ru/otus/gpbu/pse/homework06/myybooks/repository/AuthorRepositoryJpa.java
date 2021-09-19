package ru.otus.gpbu.pse.homework06.myybooks.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class AuthorRepositoryJpa implements AuthorRepository{

    @PersistenceContext
    private final EntityManager em;

    public AuthorRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Author> getById(long id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }

    @Override
    public long insert(Author author) {
        return 0;
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
