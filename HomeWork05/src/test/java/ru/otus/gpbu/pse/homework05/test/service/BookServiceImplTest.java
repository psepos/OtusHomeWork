package ru.otus.gpbu.pse.homework05.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework05.myybooks.repository.BookDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Author;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Book;
import ru.otus.gpbu.pse.homework05.myybooks.domain.DomainObjectFactory;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.service.AuthorService;
import ru.otus.gpbu.pse.homework05.myybooks.service.BookService;
import ru.otus.gpbu.pse.homework05.myybooks.service.BookServiceImpl;
import ru.otus.gpbu.pse.homework05.myybooks.service.GenreService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class BookServiceImplTest {

    private List<Book> books;
    private List<Genre> genres;
    private List<Author> authors;

    @Mock
    private BookDao bookDao;

    @Mock
    private AuthorService authorService;

    @Mock
    private GenreService genreService;

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl(bookDao, genreService, authorService);
        genres = new ArrayList<>();

        genres.add(DomainObjectFactory.getGenre(1L,"Genre1"));
        genres.add(DomainObjectFactory.getGenre(2L,"Genre2"));

        authors = new ArrayList<>();
        authors.add(DomainObjectFactory.getAuthor(1L, "Author1"));
        authors.add(DomainObjectFactory.getAuthor(2L, "Author2"));
        authors.add(DomainObjectFactory.getAuthor(3L, "Author3"));

        books = new ArrayList<>();
        books.add(DomainObjectFactory.getBook(1L,"Book1", genres.get(0), authors.get(0)));
        books.add(DomainObjectFactory.getBook(2L,"Book2", genres.get(1), authors.get(1)));
        books.add(DomainObjectFactory.getBook(3L,"Book3", genres.get(1), authors.get(2)));
    }

    @Test
    void getById() {
        given(bookDao.getById(1)).willReturn(books.get(0));
        given(bookDao.getById(2)).willReturn(books.get(1));

        Book book = bookService.getById(1);

        assertNotNull(book);
        assertEquals(1L, book.id());
        assertEquals("Book1", book.name());
        assertEquals("Genre1", book.genre().name());
        assertEquals("Author1", book.author().name());
    }


}