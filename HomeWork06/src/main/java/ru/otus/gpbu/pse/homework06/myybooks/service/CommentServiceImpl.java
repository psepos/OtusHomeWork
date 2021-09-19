package ru.otus.gpbu.pse.homework06.myybooks.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework06.myybooks.models.Comment;
import ru.otus.gpbu.pse.homework06.myybooks.models.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework06.myybooks.repository.CommentRepository;

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
    @Transactional
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
    public void update(Comment comment) {
        repository.update(comment);
    }

    @Override
    @Transactional
    public void update(long id, String description) {
        Comment comment = ModelsObjectFactory.getComment(id, description);
        repository.update(comment);
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        return repository.deleteById(id);
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
