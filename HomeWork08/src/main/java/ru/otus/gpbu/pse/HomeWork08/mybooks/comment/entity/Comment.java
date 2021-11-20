package ru.otus.gpbu.pse.homework08.mybooks.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    private long id;

    private String description;

    private Book book;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", bookId=" + book.getId() +
                '}';
    }

}
