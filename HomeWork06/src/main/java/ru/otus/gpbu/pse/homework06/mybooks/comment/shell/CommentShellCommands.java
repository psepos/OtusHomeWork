package ru.otus.gpbu.pse.homework06.mybooks.comment.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework06.mybooks.comment.service.CommentService;

import java.util.List;

@ShellComponent
public class CommentShellCommands {

    private final CommentService service;

    public CommentShellCommands(CommentService commentService) {
        this.service = commentService;
    }

    @ShellMethod(value = "comment-count", key = "cc")
    public long commentCount() {
        return service.count();
    }

    @ShellMethod(value = "comment-get-all", key = "cga")
    public List<Comment> commentGetAll() {
        return service.getAll();
    }

    @ShellMethod(value = "comment-delete-by-id <id>", key = "cdbi")
    public long commentDeleteById(Long id) {
        return service.deleteById(id);
    }

    @ShellMethod(value = "comment-get-by-id <id>", key = "cgbi")
    public Comment commentGetById(Long id) {
        return service.getById(id).get();
    }

    @ShellMethod(value = "comment-insert <description>", key = "ci")
    public long commentInsert(String description) {
        return service.insert(description);
    }

    @ShellMethod(value = "comment-update <id> <description>", key = "cu")
    public String commentUpdate(Long id, String description) {
        service.update(id, description);
        return "Ok";
    }

}
