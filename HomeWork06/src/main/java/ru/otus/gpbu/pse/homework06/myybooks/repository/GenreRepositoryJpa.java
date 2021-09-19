package ru.otus.gpbu.pse.homework06.myybooks.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
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
        if (genre.id() > 0) {
            em.merge(genre);
        } else {
            em.persist(genre);
        }
        return genre.id();
    }

    @Override
    public void update(Genre genre) {
        this.insert(genre);
    }

    @Override
    public long deleteById(long id) {
        return em
                .createQuery("DELETE FROM Genre a WHERE a.id =: id")
                .setParameter("id", id)
                .executeUpdate();
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
