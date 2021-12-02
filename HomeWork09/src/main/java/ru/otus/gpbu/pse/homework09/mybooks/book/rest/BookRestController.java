package ru.otus.gpbu.pse.homework09.mybooks.book.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.book.Book;
import ru.otus.gpbu.pse.homework09.mybooks.book.service.BookService;
import ru.otus.gpbu.pse.homework09.mybooks.comment.rest.CommentDto;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;

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
    @GetMapping("/{id}")
    public String viewPage(@PathVariable("id") long id, Model model) throws NotFoundException {

        Book book = bookService.getById(id).orElseThrow(NotFoundException::new);

        BookDto bookDto = BookDto.toDto(book);
        List<CommentDto> comments = CommentDto.toDto(book.getComments());
        model.addAttribute("book", bookDto);
        model.addAttribute("comments", comments);
        return "book-view";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        BookDto book = BookDto.toDto(bookService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("book", book);
        return "book-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        BookForEditDto book = BookForEditDto.toDto(ModelsObjectFactory.getBook());
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping(value = "/edit", params = "action=save")
    public String editSave(BookForEditDto bookDto, Model model) {

        long bookId = bookDto.getId();

        if (bookId > 0) {

            Optional<Book> bookOpt = bookService.getById(bookId);
            bookOpt.ifPresent(b -> {
                Book book = BookForEditDto.refreshModel(b, bookDto);
                bookService.update(book);
                model.addAttribute(book);
            });
        }
        else {
            Book book = BookForEditDto.toModel(bookDto);
            bookService.insert(book);
        }

        return "redirect:/library/books";
    }

    @PostMapping(value = "/{id}/edit", params = "action=cancel")
    public String editCancel() {
        return "redirect:/library/books";
    }

    @PostMapping(value = "/{id}", params = "action=cancel")
    public String viewCancel() {
        return "redirect:/library/books";
    }

    @PostMapping(value = "/{id}", params = "action=edit")
    public String viewEdit(@PathVariable("id") long id) {
        return "redirect:/library/books/" + id + "/edit";
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public String delete(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return "redirect:/library/books";
    }

    @PostMapping(value = "/{id}/delete", params = "action=cancel")
    public String deleteCancel() {
        return "redirect:/library/books";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage());
    }
}
