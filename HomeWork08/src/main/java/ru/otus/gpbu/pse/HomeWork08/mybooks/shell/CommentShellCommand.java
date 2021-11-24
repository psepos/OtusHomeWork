package ru.otus.gpbu.pse.homework08.mybooks.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.CommentService;

import java.util.List;

@ShellComponent
public class CommentShellCommand {

    private final CommentService commentService;

    private Comment comment = Comment.get();

    public CommentShellCommand(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod(value = "find-all-comment", key = "c-find")
    public List<Comment> findAllComment() {
        return commentService.findAll();
    }

    @ShellMethod(value = "create-comment", key = "c-cr")
    public Comment createComment() {
        comment = Comment.get();
        return comment;
    }

    @ShellMethod(value = "delete-comment-by-id", key = "c-del")
    public String deleteCommentById(String id) {
        Comment comment1 = Comment.get();
        comment1.setId(id);

        commentService.delete(comment1);

        return "successfully deleted";
    }
}
