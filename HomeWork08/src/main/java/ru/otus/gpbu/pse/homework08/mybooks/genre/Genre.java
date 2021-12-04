package ru.otus.gpbu.pse.homework08.mybooks.genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;

public @Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genre")
class Genre implements LastUpdated {

    @Id
    private String id;

    private String name;

    private LocalDateTime lastUpdate;

    public static Genre get() {
        return new Genre();
    }

    public static Genre get(String genreId) {
        Genre genre = new Genre();
        genre.setId(genreId);
        return genre;
    }

    public static Genre get(String genreId, String genreName) {
        Genre genre = Genre.get(genreId);
        genre.setName(genreName);
        return genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
