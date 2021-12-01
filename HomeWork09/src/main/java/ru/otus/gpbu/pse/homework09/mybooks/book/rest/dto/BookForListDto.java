package ru.otus.gpbu.pse.homework09.mybooks.book.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.author.model.Author;
import ru.otus.gpbu.pse.homework09.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework09.mybooks.genre.entity.Genre;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForListDto {

    private long id;
    private String name;
    private String genre;
    private String author;

    public static BookForListDto toDto(Book book) {
        Genre genre = book.getGenre();
        Author author = book.getAuthor();

        return new BookForListDto(
                book.getId(),
                book.getName(),
                (genre != null) ? genre.getName() : "",
                (author != null) ? author.getName() : "");
    }

    public static List<BookForListDto> toDto(List<Book> book) {
        List<BookForListDto> booksDto = new ArrayList<>();
        book.forEach((b -> booksDto.add(BookForListDto.toDto(b))));
        return booksDto;
    }

}
