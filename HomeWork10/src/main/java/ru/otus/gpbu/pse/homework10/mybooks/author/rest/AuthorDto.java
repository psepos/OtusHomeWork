package ru.otus.gpbu.pse.homework10.mybooks.author.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework10.mybooks.author.Author;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private long authorId;
    private String authorName;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    public static List<AuthorDto> toDto(List<Author> authors) {
        List<AuthorDto> authorsDto = new ArrayList<>();
        authors.forEach((author -> authorsDto.add(AuthorDto.toDto(author))));
        return authorsDto;
    }

    public static Author toModel(AuthorDto authorDto) {
        return new Author(authorDto.getAuthorId(), authorDto.getAuthorName());
    }

}
