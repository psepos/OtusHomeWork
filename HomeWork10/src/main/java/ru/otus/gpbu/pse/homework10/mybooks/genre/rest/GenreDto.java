package ru.otus.gpbu.pse.homework10.mybooks.genre.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework10.mybooks.genre.Genre;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private long genreId;
    private String genreName;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    public static Genre toModel(GenreDto genre) {
        return new Genre(genre.getGenreId(), genre.getGenreName());
    }

    public static List<GenreDto> toDto(List<Genre> genres) {
        List<GenreDto> genresDto = new ArrayList<>();
        genres.forEach((g -> genresDto.add(GenreDto.toDto(g))));
        return genresDto;
    }

    @Override
    public String toString() {
        return "GenreDto{" +
                "id=" + genreId +
                ", name='" + genreName + '\'' +
                '}';
    }
}
