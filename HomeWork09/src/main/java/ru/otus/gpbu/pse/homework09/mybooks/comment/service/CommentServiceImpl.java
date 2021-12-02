package ru.otus.gpbu.pse.homework09.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.repository.CommentRepository;

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
        return Optional.of(repository.getById(id));
    }

    @Override
    public Comment insert(Comment comment) {
        repository.save(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        repository.save(comment);
        return comment;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Comment> getAll() {
        return repository.findAll();
    }

}
