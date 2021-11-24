package ru.otus.gpbu.pse.homework08.mybooks.genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
public @Data
class Genre implements LastUpdated {
    private String name;

    private LocalDateTime lastUpdate;

    public static Genre get() {
        return new Genre();
    }

    public static Genre get(String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);
        return genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
