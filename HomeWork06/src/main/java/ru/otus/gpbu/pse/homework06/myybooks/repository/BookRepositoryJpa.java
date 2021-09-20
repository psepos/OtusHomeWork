package ru.otus.gpbu.pse.homework06.myybooks.repository;

import org.springframework.stereotype.Repository;
import ru.otus.gpbu.pse.homework06.myybooks.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpa implements BookRepository{

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
        return 0;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public long deleteById(long id) {
        return 0;
    }

    @Override
    public List<Book> getAll() {
        return em.createQuery("SELECT e FROM Book e", Book.class).getResultList();
    }

    @Override
    public long count() {
        return 0;
    }
}
