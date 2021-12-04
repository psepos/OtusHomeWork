package ru.otus.gpbu.pse.homework09.mybooks.comment.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.comment.Comment;
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
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        CommentDto comment = CommentDto.toDto(commentService.findById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("comment", comment);
        return "comment-edit";
    }

    @PostMapping(value = "/{id}/edit", params = "action=save")
    public String savePageSave(@ModelAttribute("comment") CommentDto commentDto) {
        Comment comment = CommentDto.toModel(commentDto);
        commentService.update(comment);
        return "redirect:/library/books/";
    }

    @PostMapping(value = "/{id}/edit", params = "action=delete")
    public String editPageDelete(@PathVariable("id") long id) {
        commentService.deleteById(id);
        return "redirect:/library/books/";
    }

    @PostMapping(value = "/{id}/edit", params = "action=cancel")
    public String editPageCancel() {
        return "redirect:/library/books/";
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
