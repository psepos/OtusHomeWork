package ru.otus.gpbu.pse.homework09.mybooks.book.service;

import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.dto.BookDto;

import java.util.List;

public interface BookMappingService {
    BookDto toDto(Book book);
    List<BookDto> toDto(List<Book> book);
    Book toModel(BookDto bookDto);
    Book refreshModel(Book book, BookDto bookDto);
}
