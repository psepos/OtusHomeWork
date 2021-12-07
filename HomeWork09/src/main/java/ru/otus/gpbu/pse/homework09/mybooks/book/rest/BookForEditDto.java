package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class BookForEditDto {
    private long bookId;
    private String bookName;

    public static BookForEditDto toDto(Book book) {
        return new BookForEditDto(book.getId(), book.getName());
    }

    public static Book toModel(BookForEditDto bookDto) {
        return ModelsObjectFactory.getBook(bookDto.getBookId(), bookDto.getBookName());
    }

    public static Book refreshModel(Book book, BookForEditDto bookDto) {
        book.setName(bookDto.getBookName());
        return book;
    }
}
