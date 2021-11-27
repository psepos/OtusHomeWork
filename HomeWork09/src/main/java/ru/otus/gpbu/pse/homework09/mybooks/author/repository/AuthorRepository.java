package ru.otus.gpbu.pse.homework09.mybooks.author.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.pse.homework09.mybooks.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
