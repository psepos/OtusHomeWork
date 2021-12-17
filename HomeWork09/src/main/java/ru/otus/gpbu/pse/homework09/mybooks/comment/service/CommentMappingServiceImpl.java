package ru.otus.gpbu.pse.homework09.mybooks.comment.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.dto.CommentDto;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentMappingServiceImpl implements CommentMappingService {
    @Override
    public CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(),comment.getDescription(), comment.getBook().getId());
    }

    @Override
    public List<CommentDto> toDto(List<Comment> comment) {
        List<CommentDto> commentsDto = new ArrayList<>();
        comment.forEach(c -> commentsDto.add(toDto(c)));
        return commentsDto;
    }

    @Override
    public Comment toModel(CommentDto comment) {
        return ModelsObjectFactory.getComment(comment.getCommentId(),comment.getCommentDescription());
    }

    @Override
    public Comment toModel(CommentDto comment, Book book) {
        return ModelsObjectFactory.getComment(comment.getCommentId(),comment.getCommentDescription(), book);
    }
}
