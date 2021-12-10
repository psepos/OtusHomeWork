package ru.otus.gpbu.pse.homework09.mybooks.book.service;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.dto.BookDto;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMappingServiceImpl implements BookMappingService {
    @Override
    public BookDto toDto(Book book) {
        Genre genre = book.getGenre();
        Author author = book.getAuthor();

        return new BookDto(
                book.getId(),
                book.getName(),
                (genre != null) ? genre.getName() : "",
                (author != null) ? author.getName() : "");
    }

    @Override
    public List<BookDto> toDto(List<Book> book) {
        List<BookDto> booksDto = new ArrayList<>();
        book.forEach((b -> booksDto.add(this.toDto(b))));
        return booksDto;
    }

    @Override
    public Book toModel(BookDto bookDto) {
        return ModelsObjectFactory.getBook(bookDto.getBookId(), bookDto.getBookName());
    }

    @Override
    public Book refreshModel(Book book, BookDto bookDto) {
        book.setName(bookDto.getBookName());
        return book;
    }
}
