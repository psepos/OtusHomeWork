package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.author.rest.NotFoundException;
import ru.otus.gpbu.pse.homework09.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.entity.BookDto;
import ru.otus.gpbu.pse.homework09.mybooks.book.service.BookService;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/library/books")
@Slf4j
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<BookDto> books = BookDto.toDto(bookService.getAll());

        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        BookDto book = BookDto.toDto(bookService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("book", book);
        return "book-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        BookDto book = BookDto.toDto(ModelsObjectFactory.getBook());
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping(value = "/edit", params = "action=save")
    public String editSave(BookDto bookDto, Model model) {
        Optional<Book> bookOpt = bookService.getById(bookDto.getId());

        bookOpt.ifPresent(b -> {
            Book book = BookDto.toModel(b, bookDto);
            bookService.update(book);
            model.addAttribute(book);
        });

        return "redirect:/library/books";
    }

    @PostMapping(value = "/edit", params = "action=cancel")
    public String editCancel() {
        return "redirect:/library/books";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) throws NotFoundException {
        BookDto book = BookDto.toDto(bookService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("book", book);
        return "book-delete";
    }

    @PostMapping(value = "/delete", params = "action=delete")
    public String delete(BookDto bookDto) {
        bookService.deleteById(bookDto.getId());
        return "redirect:/library/books";
    }

    @PostMapping(value = "/delete", params = "action=cancel")
    public String deleteCancel() {
        return "redirect:/library/books";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage());
    }
}
