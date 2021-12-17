package ru.otus.gpbu.pse.homework09.mybooks.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private long bookId;
    private String bookName;
    private String genreName;
    private String authorName;
}
