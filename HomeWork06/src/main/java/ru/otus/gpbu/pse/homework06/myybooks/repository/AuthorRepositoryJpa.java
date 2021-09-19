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
public class AuthorRepositoryJpa implements AuthorRepository {

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
        if (author.id() > 0) {
            em.merge(author);
        } else {
            em.persist(author);
        }

        return author.id();
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public int deleteById(long id) {
        return em
                .createQuery("DELETE FROM Author a WHERE a.id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Author> getAll() {
        return em.createQuery("SELECT e FROM Author e", Author.class).getResultList();
    }

    @Override
    public long count() {
        long count = 0;
        var list = em.createQuery("SELECT COUNT(a) FROM Author a").getResultList();
        if (list.size() > 0) {
            count = (long) list.get(0);
        }
        return count;
    }
}
