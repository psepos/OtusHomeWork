package ru.otus.gpbu.pse.homework08.mybooks.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.gpbu.pse.homework08.mybooks.book.Book;
import ru.otus.gpbu.pse.homework08.mybooks.common.LastUpdated;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "comment")
public class Comment implements LastUpdated {

    @Id
    private String id;

    private String bookId;

    private String description;

    private LocalDateTime lastUpdate;

    public static Comment get() {
        return new Comment();
    }

    public static Comment get(String description) {
        Comment comment = get();
        comment.setDescription(description);
        return comment;
    }

    public static Comment get(Book book, String description) {
        Comment comment = get(description);
        book.addComment(comment);
        return comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", description='" + description + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Comment setBook(Book book) {
        this.bookId = book.getId();
        return this;
    }
}
