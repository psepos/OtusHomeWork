package ru.otus.gpbu.pse.homework10.mybooks.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework10.mybooks.book.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
