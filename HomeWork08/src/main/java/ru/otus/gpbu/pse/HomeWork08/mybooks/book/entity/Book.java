package ru.otus.gpbu.pse.homework08.mybooks.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    private String id;

    private String name;

    private List<Genre> genres = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    @DBRef
    private List<Comment> comments = new ArrayList<>();

    public static Book get() {
        return new Book();
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genres=" + genres +
                ", authors=" + authors +
                ", comments=" + comments +
                '}';
    }
}
