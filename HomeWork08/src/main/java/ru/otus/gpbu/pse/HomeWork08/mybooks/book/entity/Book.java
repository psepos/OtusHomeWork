package ru.otus.gpbu.pse.homework08.mybooks.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    private long id;

    private String name;

    private Genre genre;

    private Author author;

    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setBook(null);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
