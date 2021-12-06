package ru.otus.gpbu.pse.homework09.mybooks.author.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.author.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.service.AuthorService;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/library/authors")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<AuthorDto> authors = AuthorDto.toDto(authorService.getAll());

        model.addAttribute("authors", authors);
        return "author-list";
    }

    @GetMapping("/{id}")
    public String viewPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        AuthorDto author = AuthorDto.toDto(authorService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("author", author);
        return "author-view";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        AuthorDto author = AuthorDto.toDto(authorService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("author", author);
        return "author-edit";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        AuthorDto author = AuthorDto.toDto(ModelsObjectFactory.getAuthor(""));
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping(value = "/{id}/edit", params = "action=save")
    public String editSave(AuthorDto authorDto, Model model) {
        Author author = AuthorDto.toModel(authorDto);
        authorService.update(author);
        model.addAttribute(author);
        return "redirect:/library/authors";
    }

    @PostMapping(value = "/{id}", params = "action=edit")
    public String toEditPage(@PathVariable("id") long id) {
        return "redirect:/library/authors/" + id + "/edit";
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public String viewPageDelete(@PathVariable("id") long id) {
        authorService.deleteById(id);
        return "redirect:/library/authors";
    }

    @PostMapping(value = "/{id}", params = "action=cancel")
    public String viewPageCancel() {
        return "redirect:/library/authors";
    }

    @PostMapping(value = "/{id}/edit", params = "action=cancel")
    public String editPageCancel() {
        return "redirect:/library/authors";
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
