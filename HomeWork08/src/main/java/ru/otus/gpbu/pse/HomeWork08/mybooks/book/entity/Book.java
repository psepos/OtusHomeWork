package ru.otus.gpbu.pse.homework08.mybooks.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    private String id;

    private String name;

    private List<Genre> genres;

    private List<Author> authors;

    public static Book get(){
        return new Book();
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genres=" + genres +
                ", authors=" + authors +
                '}';
    }
}
