package ru.otus.gpbu.pse.homework09.mybooks.author.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.author.model.Author;
import ru.otus.gpbu.pse.homework09.mybooks.author.rest.dto.AuthorDto;
import ru.otus.gpbu.pse.homework09.mybooks.author.service.AuthorService;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;

import java.util.List;

@Controller
@RequestMapping("/library/authors")
@Slf4j
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<AuthorDto> authors = AuthorDto.toDto(authorService.getAll());

        model.addAttribute("authors", authors);
        return "author-list";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        AuthorDto author = AuthorDto.toDto(authorService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("author", author);
        return "author-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        AuthorDto author = AuthorDto.toDto(ModelsObjectFactory.getAuthor(""));
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping(value = "/edit", params = "action=save")
    public String editSave(AuthorDto authorDto, Model model) {
        Author author = AuthorDto.toModel(authorDto);
        authorService.update(author);
        model.addAttribute(author);
        return "redirect:/library/authors";
    }

    @PostMapping(value = "/edit", params = "action=cancel")
    public String editCancel() {
        return "redirect:/library/authors";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) throws NotFoundException {
        AuthorDto author = AuthorDto.toDto(authorService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("author", author);
        return "author-delete";
    }

    @PostMapping(value = "/delete", params = "action=delete")
    public String delete(AuthorDto authorDto) {
        authorService.deleteById(authorDto.getId());
        return "redirect:/library/authors";
    }

    @PostMapping(value = "/delete", params = "action=cancel")
    public String deleteCancel() {
        return "redirect:/library/authors";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage());
    }
}
