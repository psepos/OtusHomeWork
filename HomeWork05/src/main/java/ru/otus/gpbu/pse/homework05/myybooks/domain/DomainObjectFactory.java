package ru.otus.gpbu.pse.homework05.myybooks.domain;

public class DomainObjectFactory {
    public static Author getAuthor(Long id, String name) {
        return new Author(id,name);
    }

    public static Genre getGenre(Long id, String name) {
        return new Genre(id,name);
    }
    public static Book getBook(Long id, String name, Genre genre, Author author) {
        return new Book(id,name, genre, author);
    }
}
