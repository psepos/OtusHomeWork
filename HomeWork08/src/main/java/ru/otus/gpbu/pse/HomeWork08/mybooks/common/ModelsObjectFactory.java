package ru.otus.gpbu.pse.homework08.mybooks.common;

import ru.otus.gpbu.pse.homework08.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.genre.entity.Genre;

public class ModelsObjectFactory {
    public static Author getAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    public static Genre getGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genre;
    }

    public static Book getBook(String name) {
        Book book = new Book();
        book.setName(name);
        return book;
    }

    public static Comment getComment(String description){
        Comment comment = new Comment();
        comment.setDescription(description);
        return comment;
    }
}
