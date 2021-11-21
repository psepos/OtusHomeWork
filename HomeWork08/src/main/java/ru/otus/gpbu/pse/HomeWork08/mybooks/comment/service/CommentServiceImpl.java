package ru.otus.gpbu.pse.homework08.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Optional<Comment> findById(String id) {
        return Optional.empty();
    }

    @Override
    public String insert(Comment comment) {
        return null;
    }

    @Override
    public String update(Comment comment) {
        return null;
    }

    @Override
    public String deleteById(String id) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
