package ru.otus.gpbu.pse.homework08.mybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.genre.Genre;
import ru.otus.gpbu.pse.homework08.mybooks.genre.GenreService;

import java.util.List;

@ShellComponent
public class GenreShellCommand {

    private Genre genre = Genre.get();

    private final GenreService genreService;

    public GenreShellCommand(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(value = "create-new-genre-by-name", key = "g-createN")
    public Genre createNewGenre(String name) {
        genre = Genre.get();
        genre.setName(name);
        return genre;
    }

    @ShellMethod(value = "set-name-genre", key = "g-setN")
    public Genre setNameGenre(String name) {
        genre.setName(name);
        return genre;
    }

    @ShellMethod(value = "create-new-genre", key = "g-create")
    public Genre createNewGenre() {
        genre = Genre.get();
        return genre;
    }

    @ShellMethod(value = "find-all-genre", key = "g-find-all")
    public List<Genre> findAllGenre() {
        return genreService.findAll();
    }

    @ShellMethod(value = "find-by-id-genre", key = "g-find-by-id")
    public Genre findByIdGenre(String id) {
        genre = genreService.find(Genre.get(id)).get();
        return genre;
    }

    @ShellMethod(value = "show-genre", key = "g-show")
    public Genre showGenre() {
        return genre;
    }

    @ShellMethod(value = "save-genre", key = "g-save")
    public Genre saveGenre() {
        return genreService.save(genre);
    }

    @ShellMethod(value = "delete-genre", key = "g-delete")
    public String  deleteGenre() {
        genreService.delete(genre);
        return "Successfully deleted...";
    }
}
