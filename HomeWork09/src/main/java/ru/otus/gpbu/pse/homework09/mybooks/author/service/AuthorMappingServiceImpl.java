package ru.otus.gpbu.pse.homework09.mybooks.author.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.dto.AuthorDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorMappingServiceImpl implements AuthorMappingService{

    @Override
    public AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    @Override
    public List<AuthorDto> toDto(List<Author> authors) {
        List<AuthorDto> authorsDto = new ArrayList<>();
        authors.forEach((author -> authorsDto.add(this.toDto(author))));
        return authorsDto;
    }

    @Override
    public Author toModel(AuthorDto authorDto) {
        return new Author(authorDto.getAuthorId(), authorDto.getAuthorName());
    }


}
