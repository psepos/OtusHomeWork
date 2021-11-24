package ru.otus.gpbu.pse.homework08.mybooks.book;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.CommentService;
import ru.otus.gpbu.pse.homework08.mybooks.service.TriggerService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final CommentService commentService;

    private final TriggerService triggerService;

    public BookServiceImpl(BookRepository bookRepository, CommentService commentService, TriggerService triggerService) {
        this.bookRepository = bookRepository;
        this.commentService = commentService;
        this.triggerService = triggerService;
    }

    @Override
    public Optional<Book> find(Book book) {

        Optional<Book> bookOpt = bookRepository.findById(book.getId());

        bookOpt.ifPresent(book1 -> book1.setComments(commentService.findAllByBook(book)));

        return bookOpt;
    }

    @Override
    public Book save(Book book) {

        triggerService.setLastUpdate(book);

        bookRepository.save(book);
        for (Comment comment : book.getComments()) {
            comment.setBook(book);
            commentService.save(comment);
        }
        return book;
    }

    @Override
    public void delete(Book book) {
        commentService.deleteAllByBook(book);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach((book) -> book.setComments(commentService.findAllByBook(book)));
        return books;
    }

}
