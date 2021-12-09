package ru.otus.gpbu.pse.homework10.mybooks.author.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework10.mybooks.author.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
