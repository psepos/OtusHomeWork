package ru.otus.gpbu.pse.homework09.mybooks.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    private String description;

    public static CommentDto commentDto(Comment comment) {
        return new CommentDto(comment.getId(),comment.getDescription());
    }
}
