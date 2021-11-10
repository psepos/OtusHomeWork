package ru.otus.gpbu.mygena.models.myentityattribute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import java.util.List;

public interface MyEntityAttributeRepository extends JpaRepository<MyEntityAttribute, Long> {
    List<MyEntityAttribute> findAllByEntity(MyEntity entity);

}
