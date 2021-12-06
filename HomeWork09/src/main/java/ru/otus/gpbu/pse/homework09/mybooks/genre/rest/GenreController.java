package ru.otus.gpbu.pse.homework09.mybooks.genre.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/library/genres")
@Slf4j
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<GenreDto> genres = GenreDto.toDto(genreService.getAll());

        model.addAttribute("genres", genres);
        return "genre-list";
    }

    @GetMapping("/{id}")
    public String viewPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        GenreDto genre = GenreDto.toDto(genreService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("genre", genre);
        return "genre-view";
    }

    @GetMapping("/{id}/edit")
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

    @PostMapping(value = "/{id}/edit", params = "action=save")
    public String editSave(GenreDto genreDto, Model model) {
        Genre genre = GenreDto.toModel(genreDto);
        genreService.update(genre);
        model.addAttribute(genre);
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/{id}/edit", params = "action=cancel")
    public String toHomePage() {
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/{id}", params = "action=edit")
    public String toEditPage(@PathVariable("id") long id) {
        return "redirect:/library/genres/" + id + "/edit";
    }

    @PostMapping(value = "/{id}", params = "action=cancel")
    public String toHomePage(@PathVariable("id") long id) {
        return "redirect:/library/genres/";
    }

    @PostMapping(value = "/edit", params = "action=cancel")
    public String editCancel() {
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/{id}", params = "action=delete")
    public String delete(@PathVariable("id") long id) {
        genreService.deleteById(id);
        return "redirect:/library/genres";
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
