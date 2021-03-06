package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.dto.AuthorDto;
import ru.otus.gpbu.pse.homework09.mybooks.author.service.AuthorMappingService;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.dto.BookDto;
import ru.otus.gpbu.pse.homework09.mybooks.book.dto.CommentForBookDto;
import ru.otus.gpbu.pse.homework09.mybooks.book.service.BookMappingService;
import ru.otus.gpbu.pse.homework09.mybooks.book.service.BookService;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.dto.GenreDto;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreMappingService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/library/books")
@Slf4j
public class BookController {

    private final BookService bookService;
    private final AuthorMappingService authorMappingService;

    // Mappings
    private final BookMappingService bookMappingService;
    private final GenreMappingService genreMappingService;

    public BookController(BookService bookService, AuthorMappingService authorMappingService, BookMappingService bookMappingService, GenreMappingService genreMappingService) {
        this.bookService = bookService;
        this.authorMappingService = authorMappingService;
        this.bookMappingService = bookMappingService;
        this.genreMappingService = genreMappingService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<BookDto> books = bookMappingService.toDto(bookService.getAll());

        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/{id}")
    public String viewPage(@PathVariable("id") long id, Model model) throws NotFoundException {

        Book book = bookService.findById(id).orElseThrow(NotFoundException::new);
        BookDto bookDto = bookMappingService.toDto(bookService.findById(id).orElseThrow(NotFoundException::new));
        CommentForBookDto comment = CommentForBookDto.toDto(ModelsObjectFactory.getComment(-1, ""));

        List<CommentForBookDto> comments = CommentForBookDto.toDto(book.getComments());

        model.addAttribute("book", bookDto);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", comment);

        return "book-view";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {

        Book book = bookService.findById(id).orElseThrow(NotFoundException::new);
        BookDto bookDto = bookMappingService.toDto(book);
        GenreDto genreDto = genreMappingService.toDto(book.getGenre());
        AuthorDto authorDto = authorMappingService.toDto(book.getAuthor());

        model.addAttribute("book", bookDto);
        model.addAttribute("genre", genreDto);
        model.addAttribute("author", authorDto);
        return "book-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        BookDto book = bookMappingService.toDto(ModelsObjectFactory.getBook());
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping(value = "/save")
    public String editSave(@PathVariable("id") long id, BookDto bookDto, GenreDto genreDto, AuthorDto authorDto) {

        long bookId = bookDto.getBookId();
        Genre genre = genreMappingService.toModel(genreDto);
        Author author = authorMappingService.toModel(authorDto);

        if (bookId > 0) {

            Optional<Book> bookOpt = bookService.findById(bookId);
            bookOpt.ifPresent(b -> {
                Book book = bookMappingService.refreshModel(b, bookDto);
                book.setAuthor(author);
                book.setGenre(genre);

                bookService.update(book);
            });
        } else {
            Book book = bookMappingService.toModel(bookDto);
            book.setAuthor(author);
            book.setGenre(genre);

            bookService.insert(book);
        }

        return "redirect:/library/books/" + id;
    }

    @PostMapping(value = "/{id}", params = "action=add-comment")
    public String addComment(BookDto bookDto, @ModelAttribute("comment") CommentForBookDto comment) {

        bookService.findById(bookDto.getBookId()).ifPresent(b -> {
            b.addComment(CommentForBookDto.toModel(comment));
            bookService.update(b);
        });

        return "redirect:/library/books/" + bookDto.getBookId();
    }

    @PostMapping(value = "/delete")
    public String delete(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return "redirect:/library/books";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String message = ex.getMessage() + Arrays.toString(ex.getStackTrace());
        log.error(message);
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage() + " " + Arrays.toString(ex.getStackTrace()));
    }
}
