package ru.otus.gpbu.pse.homework08.mybooks.book.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.gpbu.pse.homework08.mybooks.book.entity.Book;

public interface BookRepository extends MongoRepository<Book, Long> {

}
