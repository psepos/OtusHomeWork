package ru.otus.gpbu.pse.homework08.mybooks.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
