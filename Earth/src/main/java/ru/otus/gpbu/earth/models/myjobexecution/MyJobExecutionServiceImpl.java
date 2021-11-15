package ru.otus.gpbu.earth.models.myjobexecution;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyJobExecutionServiceImpl implements MyJobExecutionService {

    private final myJobExecutionRepository repository;

    public MyJobExecutionServiceImpl(myJobExecutionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MyJobExecution> findAll() {
        return repository.findAll();
    }
}
