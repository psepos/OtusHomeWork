package ru.otus.gpbu.pse.homework09.mybooks.author.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.gpbu.pse.homework09.mybooks.author.model.AuthorDto;
import ru.otus.gpbu.pse.homework09.mybooks.author.service.AuthorService;

import javax.servlet.http.HttpServletRequest;
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
    public String findAll(Model model, HttpServletRequest request) {

        List<AuthorDto> authors = AuthorDto.toDto(authorService.getAll());
        var s = request;
        String mappingPath = s.getPathTranslated();

        model.addAttribute("authors", authors);
        model.addAttribute("mapping", mappingPath);
        return "author-list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model, HttpServletRequest request) throws NotFoundException {
        AuthorDto author = AuthorDto.toDto(authorService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("author", author);
        model.addAttribute("mapping", request.getPathInfo());
        return "edit";
    }

}
