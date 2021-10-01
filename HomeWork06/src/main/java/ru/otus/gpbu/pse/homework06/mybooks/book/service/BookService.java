package ru.otus.gpbu.pse.homework06.mybooks.book.service;

import ru.otus.gpbu.pse.homework06.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getById(long id);
    long insert(Book book);
    long insert(String name, Long genre_id, Long author_id);
    long update(Book book);
    long update(Long id, String name, Long genre_id, Long author_id);
    long deleteById(long id);
    List<Book> getAll();
    long count();
    long insertComment(Book book, Comment comment);
    long insertComment(long bookId, long commentId);
    long insertComment(long bookId, String commentDescription);
    long deleteComment(Book book, Comment comment);
    long deleteComment(long bookId, long commentId);
    List<Comment> getComments(long bookId);
}
