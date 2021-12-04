package ru.otus.gpbu.pse.homework08.mybooks.genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> find(Genre genre);
    List<Genre> findAll();
    List<Genre> findAll(List<String> ids);
    Genre save(Genre genre);
    void delete(Genre genre);

}
