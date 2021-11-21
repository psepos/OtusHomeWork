package ru.otus.gpbu.pse.homework08.mybooks.comment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.gpbu.pse.homework08.mybooks.comment.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
