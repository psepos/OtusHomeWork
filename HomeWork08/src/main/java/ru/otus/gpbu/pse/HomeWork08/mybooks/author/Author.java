package ru.otus.gpbu.pse.homework08.mybooks.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class Author implements LastUpdated {

    private String name;

    private LocalDateTime lastUpdate;

    public static Author get() {
        return new Author();
    }

    public static Author get(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}