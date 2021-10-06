package ru.otus.gpbu.pse.homework06.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework06.mybooks.comment.repository.CommentRepository;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.repository = commentRepository;
    }

    @Override
    public Optional<Comment> getById(long id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public long insert(Comment comment) {
        return repository.insert(comment);
    }

    @Override
    @Transactional
    public long insert(String description) {
        Comment comment = ModelsObjectFactory.getComment(description);

        return repository.insert(comment);
    }

    @Override
    @Transactional
    public long update(Comment comment) {
        return repository.update(comment);
    }

    @Override
    @Transactional
    public long update(long id, String description) {
        Comment comment = ModelsObjectFactory.getComment(id, description);
        return repository.update(comment);
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        Optional<Comment> commentOpt = repository.getById(id);
        if (commentOpt.isEmpty()) {
            return -1;
        }
        return repository.delete(commentOpt.get());
    }

    @Override
    public List<Comment> getAll() {
        return repository.getAll();
    }

    @Override
    public long count() {
        return repository.count();
    }
}
