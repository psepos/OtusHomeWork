package ru.otus.gpbu.pse.homework07.mybooks.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework07.mybooks.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
