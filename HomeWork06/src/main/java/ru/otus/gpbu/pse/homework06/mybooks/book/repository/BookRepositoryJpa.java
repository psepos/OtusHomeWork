package ru.otus.gpbu.pse.homework06.mybooks.book.repository;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
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
    public long delete(Book book) {
        em.remove(book);
        return 0;
    }

    @Override
    public List<Book> getAll() {
        var result = em.createQuery("SELECT b FROM Book b JOIN FETCH b.genre JOIN FETCH b.author", Book.class).getResultList();
        return result;
    }

    @Override
    public long count() {
        return (long) em.createQuery("SELECT COUNT(*) FROM Book").getSingleResult();
    }

}
