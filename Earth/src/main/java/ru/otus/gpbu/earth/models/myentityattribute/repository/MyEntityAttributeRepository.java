package ru.otus.gpbu.earth.models.myentityattribute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttribute;

import java.util.List;

public interface MyEntityAttributeRepository extends JpaRepository<MyEntityAttribute, Long> {
    List<MyEntityAttribute> findAllByEntity(MyEntity entity);

}
