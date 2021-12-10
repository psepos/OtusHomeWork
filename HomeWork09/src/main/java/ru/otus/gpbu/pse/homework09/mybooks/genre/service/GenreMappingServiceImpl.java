package ru.otus.gpbu.pse.homework09.mybooks.genre.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.dto.GenreDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreMappingServiceImpl implements GenreMappingService {
    @Override
    public GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    @Override
    public Genre toModel(GenreDto genre) {
        return new Genre(genre.getGenreId(), genre.getGenreName());
    }

    @Override
    public List<GenreDto> toDto(List<Genre> genres) {
        List<GenreDto> genresDto = new ArrayList<>();
        genres.forEach((g -> genresDto.add(this.toDto(g))));
        return genresDto;
    }
}
