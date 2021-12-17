package ru.otus.gpbu.pse.homework09.mybooks.genre.service;

import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.dto.GenreDto;

import java.util.List;

public interface GenreMappingService {
    GenreDto toDto(Genre genre);
    Genre toModel(GenreDto genre);
    List<GenreDto> toDto(List<Genre> genres);
}
