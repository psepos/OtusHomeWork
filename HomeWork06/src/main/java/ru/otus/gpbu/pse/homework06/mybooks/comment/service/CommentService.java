package ru.otus.gpbu.pse.homework06.mybooks.comment.service;

import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<Comment> getById(long id);
    long insert(Comment comment);
    long insert(String description);
    long update(Comment comment);
    long update(long id, String description);
    long deleteById(long id);
    List<Comment> getAll();
    long count();

}
