package ru.otus.gpbu.mygena.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long>  {
}
