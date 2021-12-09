package ru.otus.gpbu.pse.homework10.mybooks.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework10.mybooks.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
