package ru.otus.gpbu.pse.homework09.mybooks.comment.service;

import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.dto.CommentDto;

import java.util.List;

public interface CommentMappingService {
    CommentDto toDto(Comment comment);
    List<CommentDto> toDto(List<Comment> comment);
    Comment toModel(CommentDto comment);
    Comment toModel(CommentDto comment, Book book);
}
