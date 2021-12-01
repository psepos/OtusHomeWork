package ru.otus.gpbu.pse.homework09.mybooks.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private long id;
    private String name;
    private String genre;
    private String author;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getGenre().getName(), book.getAuthor().getName());
    }

    public static List<BookDto> toDto(List<Book> book) {
        List<BookDto> booksDto = new ArrayList<>();
        book.forEach((b -> booksDto.add(BookDto.toDto(b))));
        return booksDto;
    }

    public static Book toModel(Book book, BookDto bookDto) {
        book.setName(bookDto.getName());
        return book;
    }

}
