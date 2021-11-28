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

    @ShellMethod(value = "find-all-comment", key = "c-find-all")
    public List<Comment> findAllComment() {
        return commentService.findAll();
    }

    @ShellMethod(value = "create-comment", key = "c-create")
    public Comment createComment() {
        comment = Comment.get();
        return comment;
    }

    @ShellMethod(value = "delete-comment-by-id", key = "c-delete")
    public String deleteCommentById(String id) {
        Comment comment1 = Comment.get();
        comment1.setId(id);

        commentService.delete(comment1);

        return "successfully deleted";
    }

    @ShellMethod(value = "save-comment", key = "c-save")
    public Comment saveComment() {
        return commentService.save(comment);
    }

    @ShellMethod(value = "show-comment", key = "c-show")
    public Comment showComment() {
        return comment;
    }

    @ShellMethod(value = "add-book-id-comment", key = "c-addBi")
    public Comment addBookId(String bookId) {
        comment.setBookId(bookId);
        return comment;
    }

    @ShellMethod(value = "add-description-comment", key = "c-addD")
    public Comment addDesc(String description) {
        comment.setDescription(description);
        return comment;
    }

    @ShellMethod(value = "find-by-id-comment", key = "c-find-by-id")
    public Comment findById(String id) {
        Comment comm = Comment.get();
        comm.setId(id);
        comment = commentService.find(comm).get();

        return comment;
    }
}
