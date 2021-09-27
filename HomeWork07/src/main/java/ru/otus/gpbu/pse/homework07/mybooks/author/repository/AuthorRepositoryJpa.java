package ru.otus.gpbu.pse.homework07.mybooks.author.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework07.mybooks.author.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
        if (author.getId() > 0) {
            em.merge(author);
        } else {
            em.persist(author);
        }

        return author.getId();
    }

    @Override
    public void update(Author author) {
        this.insert(author);
    }

    @Override
    public long deleteById(long id) {
        return em
                .createQuery("DELETE FROM Author a WHERE a.id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Author> getAll() {
        return em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
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
