package ru.otus.gpbu.pse.homework09.mybooks.comment.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long commentId;
    private String commentDescription;
    private long bookId;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(),comment.getDescription(), comment.getBook().getId());
    }

    public static List<CommentDto> toDto(List<Comment> comment) {
        List<CommentDto> commentsDto = new ArrayList<>();
        comment.forEach(c -> commentsDto.add(toDto(c)));
        return commentsDto;
    }

    public static Comment toModel(CommentDto comment) {
        return ModelsObjectFactory.getComment(comment.getCommentId(),comment.getCommentDescription());
    }

    public static Comment toModel(CommentDto comment, Book book) {
        return ModelsObjectFactory.getComment(comment.getCommentId(),comment.getCommentDescription(), book);
    }
}
