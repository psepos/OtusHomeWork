package ru.otus.gpbu.pse.homework09.mybooks.comment.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    private String description;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(),comment.getDescription());
    }

    public static List<CommentDto> toDto(List<Comment> comment) {
        List<CommentDto> commentsDto = new ArrayList<>();
        comment.forEach(c -> commentsDto.add(toDto(c)));
        return commentsDto;
    }

    public static Comment toModel(CommentDto comment) {
        return ModelsObjectFactory.getComment(comment.getId(),comment.getDescription());
    }
}
