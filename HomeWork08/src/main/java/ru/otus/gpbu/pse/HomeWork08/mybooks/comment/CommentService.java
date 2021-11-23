package ru.otus.gpbu.pse.homework08.mybooks.comment;

import java.util.List;

public interface CommentService {
    List<Comment> findByBookId(String bookId);
    void delete(Comment comment);
    void deleteById(String id);
}
