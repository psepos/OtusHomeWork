package ru.otus.gpbu.pse.homework09.mybooks.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long commentId;
    private String commentDescription;
    private long bookId;
}
