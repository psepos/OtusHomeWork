package ru.otus.gpbu.pse.homework06.myybooks.service;

import ru.otus.gpbu.pse.homework06.myybooks.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<Comment> getById(long id);

    long insert(Comment comment);

    long insert(String description);

    void update(Comment comment);

    void update(long id, String description);

    long deleteById(long id);

    List<Comment> getAll();

    long count();

}
