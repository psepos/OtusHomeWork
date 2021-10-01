package ru.otus.gpbu.pse.homework07.mybooks.author.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.gpbu.pse.homework07.mybooks.author.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>,
        JpaRepository<Author, Long> {

}
