package ru.otus.gpbu.pse.homework10.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework10.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework10.mybooks.comment.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.repository = commentRepository;
    }

    @Override
    public Optional<Comment> findById(long id) {
        return repository.findById(id);
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
