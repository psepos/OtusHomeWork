package ru.otus.gpbu.pse.homework09.mybooks.author.service;

import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.dto.AuthorDto;

import java.util.List;

public interface AuthorMappingService {
    AuthorDto toDto(Author author);

    List<AuthorDto> toDto(List<Author> authors);

    Author toModel(AuthorDto authorDto);
}
