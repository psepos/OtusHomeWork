package ru.otus.gpbu.pse.homework06.myybooks.domain;

public class DomainObjectFactory {
    public static Author getAuthor(Long id, String name) {
        return new Author().id(id).name(name);
    }

    public static Author getAuthor(String name) {
        return new Author().name(name);
    }

    public static Genre getGenre(Long id, String name) {
        return new Genre().id(id).name(name);
    }

    public static Genre getGenre(String name) {
        return new Genre().name(name);
    }

    public static Book getBook(Long id, String name, Genre genre, Author author) {
        return new Book().id(id).name(name).genre(genre).author(author);
    }

    public static Book getBook(String name, Genre genre, Author author) {
        return new Book().name(name).genre(genre).author(author);
    }
}
