package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentForBookDto {
    private long commentId;
    private String description;

    public static CommentForBookDto toDto(Comment comment) {
        return new CommentForBookDto(comment.getId(),comment.getDescription());
    }

    public static List<CommentForBookDto> toDto(List<Comment> comment) {
        List<CommentForBookDto> commentsDto = new ArrayList<>();
        comment.forEach(c -> commentsDto.add(toDto(c)));
        return commentsDto;
    }

    public static Comment toModel(CommentForBookDto comment) {
        return ModelsObjectFactory.getComment(comment.getCommentId(),comment.getDescription());
    }
}
