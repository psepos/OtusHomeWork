package ru.otus.gpbu.pse.homework06.mybooks.genre.repository;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private final EntityManager em;

    public GenreRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Genre> getById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public long insert(Genre genre) {
        if (genre.getId() > 0) {
            em.merge(genre);
        } else {
            em.persist(genre);
        }
        return genre.getId();
    }

    @Override
    public long update(Genre genre) {
        return this.insert(genre);
    }

    @Override
    public long delete(Genre genre) {
        return this.delete(genre);
    }

    @Override
    public List<Genre> getAll() {
        return em.createQuery("SELECT e FROM Genre e", Genre.class).getResultList();
    }

    @Override
    public long count() {
        long count = 0;
        var list = em.createQuery("SELECT COUNT(a) FROM Genre a").getResultList();
        if (list.size() > 0) {
            count = (long) list.get(0);
        }
        return count;
    }
}
