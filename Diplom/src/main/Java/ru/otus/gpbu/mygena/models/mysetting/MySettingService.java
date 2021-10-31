package ru.otus.gpbu.mygena.models.mysetting;

import java.util.Optional;

public interface MySettingService {
    Optional<MySetting> findById(Long id);
}
