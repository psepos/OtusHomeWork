package ru.otus.gpbu.mygena.models.myentity.service;

import ru.otus.gpbu.mygena.models.myentity.MyEntity;

import java.util.List;
import java.util.Optional;

public interface MyEntityService {
    List<MyEntity> findAll();
    Optional<MyEntity> findByCode(String code);
    void saveOrUpdate(MyEntity entity);
    void delete(MyEntity entity);
}