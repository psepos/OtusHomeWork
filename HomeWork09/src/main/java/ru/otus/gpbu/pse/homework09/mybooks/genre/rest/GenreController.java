package ru.otus.gpbu.pse.homework09.mybooks.genre.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;
import ru.otus.gpbu.pse.homework09.mybooks.common.NotFoundException;
import ru.otus.gpbu.pse.homework09.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework09.mybooks.genre.dto.GenreDto;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreMappingService;
import ru.otus.gpbu.pse.homework09.mybooks.genre.service.GenreService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/library/genres")
@Slf4j
public class GenreController {
    private final GenreService genreService;
    private final GenreMappingService genreMappingService;

    public GenreController(GenreService genreService, GenreMappingService genreMappingService) {
        this.genreService = genreService;
        this.genreMappingService = genreMappingService;
    }

    @GetMapping
    public String findAll(Model model) {

        List<GenreDto> genres = genreMappingService.toDto(genreService.getAll());

        model.addAttribute("genres", genres);
        return "genre-list";
    }

    @GetMapping("/{id}")
    public String viewPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        GenreDto genre = genreMappingService.toDto(genreService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("genre", genre);
        return "genre-view";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) throws NotFoundException {
        GenreDto genre = genreMappingService.toDto(genreService.getById(id).orElseThrow(NotFoundException::new));
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @GetMapping("/create")
    public String editPage(Model model) {
        GenreDto genre = genreMappingService.toDto(ModelsObjectFactory.getGenre(""));
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @PostMapping(value = "/edit")
    public String editSave(GenreDto genreDto) {
        Genre genre = genreMappingService.toModel(genreDto);
        genreService.update(genre);
        return "redirect:/library/genres";
    }

    @PostMapping(value = "/{id}", params = "action=edit")
    public String toEditPage(@PathVariable("id") long id) {
        return "redirect:/library/genres/" + id + "/edit";
    }

    @PostMapping(value = "/delete")
    public String delete(GenreDto genreDto) {
        genreService.deleteById(genreDto.getGenreId());
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
