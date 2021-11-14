package ru.otus.gpbu.earth.models.myjobinstance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.earth.models.myjobinstance.MyJobInstance;

public interface MyJobInstanceRepository extends JpaRepository<MyJobInstance, Long> {
}
