package ru.otus.gpbu.mygena.models.mysetting;

import java.util.List;
import java.util.Optional;

public interface MySettingServiceCrud {
    Optional<MySetting> findById(Long id);
    List<MySetting> findAll();
    void saveOrUpdate(MySetting setting);
}
