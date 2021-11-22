package ru.otus.gpbu.pse.homework08.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> findById(String id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByBookId(String bookId) {
        return null;
    }
}
