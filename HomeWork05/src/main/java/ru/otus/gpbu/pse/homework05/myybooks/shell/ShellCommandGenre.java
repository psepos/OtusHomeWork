package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;
import ru.otus.gpbu.pse.homework05.myybooks.domain.Genre;
import ru.otus.gpbu.pse.homework05.myybooks.domain.ObjectFactory;

import java.util.List;

@ShellComponent
public class ShellCommandGenre {

    private final GenreDao genreDao;

    public ShellCommandGenre(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @ShellMethod(value = "genre-count")
    public Integer genreCount() {
        return genreDao.count();
    }

    @ShellMethod(value = "genre-get-all")
    public void genreGetAll() {
        List<Genre> allGenre = genreDao.getAll();
        allGenre.forEach(genre -> System.out.println(genre.toString()));
    }

    @ShellMethod(value = "genre-delete-by-id <id>")
    public void genreDeleteById(Long id) {
        genreDao.deleteById(id);
    }

    @ShellMethod(value = "genre-get-by-id <id>")
    public String genreGetById(Long id) {
        return genreDao.getById(id).toString();
    }

    @ShellMethod(value = "genre-insert <id> <name>")
    public void genreInsert(Long id, String name) {
        genreDao.insert(ObjectFactory.getGenre(id, name));
    }

    @ShellMethod(value = "genre-update <id> <name>")
    public void genreUpdate(Long id, String name) {
        genreDao.update(ObjectFactory.getGenre(id, name));
    }
}
