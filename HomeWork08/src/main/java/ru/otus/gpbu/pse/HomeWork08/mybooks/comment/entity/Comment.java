package ru.otus.gpbu.pse.homework08.mybooks.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;

    private String description;

    private Book book;


}
