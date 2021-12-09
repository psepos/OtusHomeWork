package ru.otus.gpbu.pse.homework10.mybooks.common;

import ru.otus.gpbu.pse.homework10.mybooks.author.Author;
import ru.otus.gpbu.pse.homework10.mybooks.book.Book;
import ru.otus.gpbu.pse.homework10.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework10.mybooks.genre.Genre;

import java.util.ArrayList;

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

    public static Book getBook() {
        Book book = new Book();
        book.setComments(new ArrayList<>());
        return book;
    }

    public static Book getBook(long id, String name) {
        Book book = getBook();
        book.setId(id);
        book.setName(name);
        return book;
    }

    public static Book getBook(long id, String name, Genre genre, Author author) {
        Book book = getBook(id, name);
        book.setGenre(genre);
        book.setAuthor(author);
        return book;
    }

    public static Book getBook(String name, Genre genre, Author author) {
        Book book = getBook();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(author);
        return book;
    }

    public static Comment getComment() {
        Comment comment = new Comment();
        return comment;
    }

    public static Comment getComment(String description) {
        Comment comment = getComment();
        comment.setDescription(description);
        return comment;
    }

    public static Comment getComment(long id, String description) {
        Comment comment = getComment(description);
        comment.setId(id);
        return comment;
    }

    public static Comment getComment(long id, String description, Book book) {
        Comment comment = getComment(id, description);
        comment.setBook(book);
        return comment;
    }
}
