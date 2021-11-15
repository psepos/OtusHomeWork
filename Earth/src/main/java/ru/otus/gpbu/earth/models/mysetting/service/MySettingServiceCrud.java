package ru.otus.gpbu.earth.models.mysetting.service;

import ru.otus.gpbu.earth.models.mysetting.MySetting;

import java.util.List;
import java.util.Optional;

public interface MySettingServiceCrud {
    Optional<MySetting> findById(Long id);
    Optional<MySetting> findByCode(String code);
    List<MySetting> findAll();
    void saveOrUpdate(MySetting setting);
    void deleteById(Long id);


}
