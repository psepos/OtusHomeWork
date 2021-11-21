package ru.otus.gpbu.pse.homework08.mybooks.comment.shell;

import org.springframework.shell.standard.ShellComponent;
import ru.otus.gpbu.pse.homework08.mybooks.comment.service.CommentService;


@ShellComponent
public class CommentShellCommands {

    private final CommentService service;

    public CommentShellCommands(CommentService commentService) {
        this.service = commentService;
    }


}
