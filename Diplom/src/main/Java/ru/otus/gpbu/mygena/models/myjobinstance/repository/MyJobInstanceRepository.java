package ru.otus.gpbu.mygena.models.myjobinstance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.gpbu.mygena.models.myjobinstance.MyJobInstance;

public interface MyJobInstanceRepository extends JpaRepository<MyJobInstance, Long> {
}
