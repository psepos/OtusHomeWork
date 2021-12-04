package ru.otus.gpbu.pse.homework08.mybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.author.Author;
import ru.otus.gpbu.pse.homework08.mybooks.author.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorShellCommand {
    private Author author;

    private final AuthorService authorService;

    public AuthorShellCommand(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @ShellMethod(value = "create-new-author-by-name", key = "a-createN")
    public Author createNewAuthor(String authorName) {
        author = Author.get("");
        author.setName(authorName);
        return author;
    }

    @ShellMethod(value = "set-name-author", key = "a-setN")
    public Author setNameAuthor(String name) {
        author.setName(name);
        return author;
    }

    @ShellMethod(value = "create-new-author", key = "a-create")
    public Author createNewAuthor() {
        author = Author.get();
        return author;
    }

    @ShellMethod(value = "find-all-author", key = "a-find-all")
    public List<Author> findAllAuthor() {
        return authorService.findAll();
    }

    @ShellMethod(value = "find-by-id-author", key = "a-find-by-id")
    public Author findByIdAuthor(String id) {
        author = authorService.find(Author.get(id)).get();
        return author;
    }

    @ShellMethod(value = "show-author", key = "a-show")
    public Author showAuthor() {
        return author;
    }

    @ShellMethod(value = "save-author", key = "a-save")
    public Author saveAuthor() {
        return authorService.save(author);
    }

    @ShellMethod(value = "delete-author", key = "a-delete")
    public String  deleteAuthor() {
        authorService.delete(author);
        return "Successfully deleted...";
    }
}
