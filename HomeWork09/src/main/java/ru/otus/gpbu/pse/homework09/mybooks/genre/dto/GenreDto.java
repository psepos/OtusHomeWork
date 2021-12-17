package ru.otus.gpbu.pse.homework09.mybooks.genre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    private long genreId;
    private String genreName;
}
