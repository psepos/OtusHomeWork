package ru.otus.gpbu.pse.homework06.mybooks.comment.repository;

import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Optional<Comment> getById(long id);

    long insert(Comment comment);

    long update(Comment comment);

    long delete(Comment comment);

    List<Comment> getAll();

    long count();
}
