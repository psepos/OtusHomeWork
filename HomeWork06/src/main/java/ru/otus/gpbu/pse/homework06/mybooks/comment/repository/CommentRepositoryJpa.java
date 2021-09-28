package ru.otus.gpbu.pse.homework06.mybooks.comment.repository;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    public CommentRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Comment> getById(long id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    @Override
    public long insert(Comment comment) {
        if (comment.getId() > 0) {
            em.merge(comment);
        } else {
            em.persist(comment);
        }

        return comment.getId();
    }

    @Override
    public long update(Comment comment) {
        return this.insert(comment);
    }

    @Override
    public long deleteById(long id) {
        return em
                .createQuery("DELETE FROM Comment c WHERE c.id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Comment> getAll() {
        return em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
    }

    @Override
    public long count() {
        long count = 0;
        var list = em.createQuery("SELECT COUNT(c) FROM Comment c").getResultList();
        if (list.size() > 0) {
            count = (long) list.get(0);
        }
        return count;
    }
}
