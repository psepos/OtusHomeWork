package ru.otus.gpbu.pse.homework08.mybooks.comment.service;

import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<Comment> findById(String id);
    List<Comment> findAll();
    List<Comment> findByBookId(String bookId);
}
