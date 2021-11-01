package ru.otus.gpbu.mygena.models.myentity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long>  {
    Optional<MyEntity> findByCode(String code);
}
