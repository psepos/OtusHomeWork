package ru.otus.gpbu.mygena.models.myentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.util.Optional;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long>  {
    Optional<MyEntity> findByCode(String code);
}
