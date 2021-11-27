package ru.otus.gpbu.pse.homework09.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.repository.CommentRepository;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.repository = commentRepository;
    }

    @Override
    public Comment getById(long id) {
        return repository.getById(id);
    }

    @Override
    public long insert(Comment comment) {
        return repository.save(comment).getId();
    }

    @Override
    public long insert(String description) {
        Comment comment = ModelsObjectFactory.getComment(description);

        return repository.save(comment).getId();
    }

    @Override
    public long update(Comment comment) {
        return repository.save(comment).getId();
    }

    @Override
    public long update(long id, String description) {
        Comment comment = ModelsObjectFactory.getComment(id, description);
        return repository.save(comment).getId();
    }

    @Override
    public long deleteById(long id) {
        repository.deleteById(id);
        return 1;
    }

    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }
}
