package ru.otus.gpbu.pse.homework08.mybooks.comment;

import ru.otus.gpbu.pse.homework08.mybooks.book.Book;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAllByBook(Book book);
    List<Comment> findAll();
    Optional<Comment> find(Comment comment);

    void delete(Comment comment);

    void deleteAllByBook(Book book);

    Comment save(Comment comment);

}
