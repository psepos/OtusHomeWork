package ru.otus.gpbu.pse.homework08.mybooks.comment;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.book.Book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAllByBook(Book book) {
        return commentRepository.findByBookId(book.getId());
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> find(Comment comment) {
        return commentRepository.findById(comment.getId());
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void deleteAllByBook(Book book) {
        commentRepository.deleteByBookId(book.getId());
    }

    @Override
    public Comment save(Comment comment) {

        comment.setLastUpdate(LocalDateTime.now());

        return commentRepository.save(comment);
    }
}
