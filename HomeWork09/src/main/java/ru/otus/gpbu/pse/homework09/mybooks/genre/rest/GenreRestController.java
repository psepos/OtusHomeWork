package ru.otus.gpbu.pse.homework09.mybooks.genre.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.gpbu.pse.homework09.mybooks.genre.entity.GenreDto;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreService;

import java.util.List;

@Controller
@RequestMapping("/library/genres")
@Slf4j
public class GenreRestController {
    private final GenreService genreService;

    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<GenreDto> genres = GenreDto.toDto(genreService.getAll());

        model.addAttribute("genres", genres);
        return "genre-list";
    }

}
