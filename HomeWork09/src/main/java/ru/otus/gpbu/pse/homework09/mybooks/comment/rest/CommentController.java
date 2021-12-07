package ru.otus.gpbu.pse.homework09.mybooks.comment.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.book.service.BookService;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.service.CommentService;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;

import java.util.Arrays;

@Controller
@RequestMapping("/library/comments")
@Slf4j
public class CommentController {
    private final CommentService commentService;
    private final BookService bookService;

    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        Comment comment = commentService.findById(id).orElseThrow(NotFoundException::new);
        CommentDto commentDto = CommentDto.toDto(comment);
        model.addAttribute("comment", commentDto);
        return "comment-edit";
    }

    @PostMapping(value = "/{id}/edit", params = "action=save")
    public String savePageSave(CommentDto commentDto) {

        bookService.findById(commentDto.getBookId()).ifPresent(book -> {
            commentService.update(CommentDto.toModel(commentDto, book));
        });

        return "redirect:/library/books/" + commentDto.getBookId();
    }

    @PostMapping(value = "/{id}/edit", params = "action=delete")
    public String editPageDelete(CommentDto commentDto) {
        commentService.deleteById(commentDto.getCommentId());
        return "redirect:/library/books/" + commentDto.getBookId();
    }

    @PostMapping(value = "/{id}/edit", params = "action=cancel")
    public String editPageCancel(CommentDto commentDto, Model model) {
        return "redirect:/library/books/" + commentDto.getBookId();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        String message = ex.getMessage() + Arrays.toString(ex.getStackTrace());
        log.error(message);
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }
}
