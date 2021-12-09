package ru.otus.gpbu.pse.homework10.mybooks.comment.service;

import ru.otus.gpbu.pse.homework10.mybooks.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<Comment> findById(long id);
    Comment insert(Comment comment);
    Comment update(Comment comment);
    void deleteById(long id);
    List<Comment> getAll();
}
