package ru.otus.gpbu.pse.homework09.mybooks.genre.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.genre.entity.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.rest.dto.GenreDto;
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

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        GenreDto genre = GenreDto.toDto(genreService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        GenreDto genre = GenreDto.toDto(ModelsObjectFactory.getGenre(""));
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @PostMapping(value = "/edit", params = "action=save")
    public String editSave(GenreDto genreDto, Model model) {
        Genre genre = GenreDto.toModel(genreDto);
        genreService.update(genre);
        model.addAttribute(genre);
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/edit", params = "action=cancel")
    public String editCancel() {
        return "redirect:/library/genres";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) throws NotFoundException {
        GenreDto genre = GenreDto.toDto(genreService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("genre", genre);
        return "genre-delete";
    }

    @PostMapping(value = "/delete", params = "action=delete")
    public String delete(GenreDto genreDto) {
        genreService.deleteById(genreDto.getId());
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/delete", params = "action=cancel")
    public String deleteCancel() {
        return "redirect:/library/genres";
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found: " + ex.getMessage());
    }
}
