package ru.otus.gpbu.pse.homework09.mybooks.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private long authorId;
    private String authorName;
}
