package ru.otus.gpbu.pse.homework08.mybooks.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "author")
public class Author implements LastUpdated {
    @Id
    private String id;

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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
