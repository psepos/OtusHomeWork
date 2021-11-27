package ru.otus.gpbu.pse.homework08.mybooks.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;
import ru.otus.gpbu.pse.homework08.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework08.mybooks.service.TriggerServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "book")
public class Book implements LastUpdated {

    @Id
    private String id;

    private String name;

    private LocalDateTime lastUpdate;

    private List<Genre> genres = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    @Transient
    private List<Comment> comments = new ArrayList<>();

    public static Book get() {
        return new Book();
    }
    public static Book get(String bookId) {
        Book book = new Book();
        book.setId(bookId);
        return book;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
        TriggerServiceImpl.setLastUpd(genre);
        TriggerServiceImpl.setLastUpd(this);
    }

    public void addAuthor(Author author) {
        authors.add(author);
        TriggerServiceImpl.setLastUpd(author);
        TriggerServiceImpl.setLastUpd(this);
    }

    public void deleteAuthors() {
        authors.clear();
    }

    public void deleteGenres() {
        genres.clear();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBook(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", genres=" + genres +
                ", authors=" + authors +
                ", comments=" + comments +
                '}';
    }



}
