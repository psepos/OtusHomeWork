package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;

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
        Genre genre = book.getGenre();
        Author author = book.getAuthor();

        return new BookDto(
                book.getId(),
                book.getName(),
                (genre != null) ? genre.getName() : "",
                (author != null) ? author.getName() : "");
    }

    public static List<BookDto> toDto(List<Book> book) {
        List<BookDto> booksDto = new ArrayList<>();
        book.forEach((b -> booksDto.add(BookDto.toDto(b))));
        return booksDto;
    }

}
