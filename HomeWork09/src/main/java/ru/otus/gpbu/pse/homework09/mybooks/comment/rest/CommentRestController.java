package ru.otus.gpbu.pse.homework09.mybooks.comment.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.comment.service.CommentService;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;

import java.util.Arrays;

@Controller
@RequestMapping("/library/comments")
@Slf4j
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, @RequestParam("bookId") long bookId, Model model) throws NotFoundException {
        CommentDto comment = CommentDto.toDto(commentService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("comment", comment);
        model.addAttribute("bookId", bookId);
        return "comment-edit";
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
