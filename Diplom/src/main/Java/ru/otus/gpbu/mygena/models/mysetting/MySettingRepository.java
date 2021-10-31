package ru.otus.gpbu.mygena.models.mysetting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MySettingRepository extends JpaRepository<MySetting, Long> {
    Optional<MySetting> findByCode(String code);
}
