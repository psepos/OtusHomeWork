package ru.otus.gpbu.mygena.models.myentity;

import java.util.List;
import java.util.Optional;

public interface MyEntityService {
    List<MyEntity> findAll();
    Optional<MyEntity> findByCode(String code);
}
