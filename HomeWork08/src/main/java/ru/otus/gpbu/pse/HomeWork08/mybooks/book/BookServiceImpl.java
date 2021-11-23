package ru.otus.gpbu.pse.homework08.mybooks.book;

import org.springframework.stereotype.Service;
import ru.otus.gpbu.pse.homework08.mybooks.comment.Comment;
import ru.otus.gpbu.pse.homework08.mybooks.comment.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final CommentRepository commentRepository;

    public BookServiceImpl(BookRepository bookRepository, CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Book> findById(String id) {
        Optional<Book> bookOpt = bookRepository.findById(id);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setComments(commentRepository.findByBookId(book.getId()));
        }

        return bookOpt;
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        for (Comment comment : book.getComments()) {
            comment.setBookId(book.getId());
            commentRepository.save(comment);
        }
        return book;
    }

    @Override
    public void deleteById(String bookId) {
        commentRepository.deleteByBookId(bookId);
        bookRepository.deleteById(bookId);
    }

    @Override
    public void delete(Book book) {
        commentRepository.deleteByBookId(book.getId());
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach((book) -> book.setComments(commentRepository.findByBookId(book.getId())));
        return books;
    }

}
