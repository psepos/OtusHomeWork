package ru.otus.gpbu.pse.homework05.myybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework05.myybooks.dao.GenreDao;

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
}
