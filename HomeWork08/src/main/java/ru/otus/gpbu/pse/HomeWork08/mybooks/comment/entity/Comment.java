package ru.otus.gpbu.pse.homework08.mybooks.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;

    private String bookId;

    private String description;

    public static Comment get() {
        return new Comment();
    }

    public static Comment get(String description) {
        Comment comment = get();
        comment.setDescription(description);
        return comment;
    }

    public static Comment get(String description, String bookId) {
        Comment comment = get(description);
        comment.setBookId(bookId);
        return comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", book_id='" + bookId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }



}
