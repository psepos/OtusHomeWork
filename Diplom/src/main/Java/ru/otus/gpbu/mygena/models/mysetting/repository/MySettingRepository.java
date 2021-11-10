package ru.otus.gpbu.mygena.models.mysetting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.mygena.models.mysetting.MySetting;

import java.util.Optional;

public interface MySettingRepository extends JpaRepository<MySetting, Long> {
    Optional<MySetting> findByCode(String code);
}