package ru.otus.gpbu.pse.homework06.myybooks.models;

public class ModelsObjectFactory {
    public static Author getAuthor(long id, String name) {
        Author author = new Author();
        author.setId(id);
        author.setName(name);
        return author;
    }

    public static Author getAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    public static Genre getGenre(long id, String name) {
        Genre genre = new Genre();
        genre.setId(id);
        genre.setName(name);
        return genre;
    }

    public static Genre getGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genre;
    }

    public static Book getBook(long id, String name, Genre genre, Author author) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(author);
        return book;
    }

    public static Book getBook(String name, Genre genre, Author author) {
        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(author);
        return book;
    }

    public static Comment getComment(String description){
        Comment comment = new Comment();
        comment.setDescription(description);
        return comment;
    }

    public static Comment getComment(long id, String description){
        Comment comment = new Comment();
        comment.setId(id);
        comment.setDescription(description);
        return comment;
    }
}
