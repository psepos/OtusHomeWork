package ru.otus.gpbu.pse.homework05.myybooks.domain;

public class DomainObjectFactory {
    public static Author getAuthor(Long id, String name) {
        return new Author().id(id).name(name);
    }

    public static Genre getGenre(Long id, String name) {
        return new Genre().id(id).name(name);
    }

    public static Book getBook(Long id, String name, Genre genre, Author author) {
        return new Book().id(id).name(name).genre(genre).author(author);
    }
}
