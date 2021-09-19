package ru.otus.gpbu.pse.homework06.myybooks.models;

public class ModelsObjectFactory {
    public static Author getAuthor(long id, String name) {
        return new Author().id(id).name(name);
    }

    public static Author getAuthor(String name) {
        return new Author().name(name);
    }

    public static Genre getGenre(long id, String name) {
        return new Genre().id(id).name(name);
    }

    public static Genre getGenre(String name) {
        return new Genre().name(name);
    }

    public static Book getBook(long id, String name, Genre genre, Author author) {
        return new Book().id(id).name(name).genre(genre).author(author);
    }

    public static Book getBook(String name, Genre genre, Author author) {
        return new Book().name(name).genre(genre).author(author);
    }

    public static Comment getComment(String description){
        return new Comment().description(description);
    }

    public static Comment getComment(long id, String description){
        return new Comment().id(id).description(description);
    }
}
