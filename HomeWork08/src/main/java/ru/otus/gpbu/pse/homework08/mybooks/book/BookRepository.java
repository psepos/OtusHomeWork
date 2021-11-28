package ru.otus.gpbu.pse.homework08.mybooks.book;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
