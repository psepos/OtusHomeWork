package ru.otus.gpbu.pse.homework09.mybooks.book.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForEditDto {
    private long id;
    private String name;

    public static BookForEditDto toDto(Book book) {
        return new BookForEditDto(book.getId(), book.getName());
    }

    public static Book toModel(BookForEditDto bookDto) {
        return ModelsObjectFactory.getBook(bookDto.getId(), bookDto.getName());
    }

    public static Book refreshModel(Book book, BookForEditDto bookDto) {
        book.setName(bookDto.getName());
        return book;
    }
}
