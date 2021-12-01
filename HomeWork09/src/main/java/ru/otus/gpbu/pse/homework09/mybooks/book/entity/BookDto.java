package ru.otus.gpbu.pse.homework09.mybooks.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private long id;
    private String name;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName());
    }

    public static List<BookDto> toDto(List<Book> book) {
        List<BookDto> booksDto = new ArrayList<>();
        book.forEach((b -> booksDto.add(BookDto.toDto(b))));
        return booksDto;
    }

    public static Book toModel(BookDto book) {
        return ModelsObjectFactory.getBook(book.getId(), book.getName());
    }

}
