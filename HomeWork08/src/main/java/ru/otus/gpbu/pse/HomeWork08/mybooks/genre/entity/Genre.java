package ru.otus.gpbu.pse.homework08.mybooks.genre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public @Data
class Genre {
    private String name;

    public static Genre get() {
        return new Genre();
    }

    public static Genre get(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
