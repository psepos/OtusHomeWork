package ru.otus.gpbu.pse.homework06.mybooks.book.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Book> getById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public long insert(Book book) {
        if (book.getId() > 0) {
            em.merge(book);
        } else {
            em.persist(book);
        }

        return book.getId();
    }

    @Override
    public long update(Book book) {
        return this.insert(book);
    }

    @Override
    public long deleteById(long id) {
        return em.createQuery("DELETE Book b WHERE b.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("SELECT b FROM Book b JOIN FETCH b.genre JOIN FETCH b.author", Book.class).getResultList();
    }

    @Override
    public long count() {
        return (long) em.createQuery("SELECT COUNT(*) FROM Book").getSingleResult();
    }

}
