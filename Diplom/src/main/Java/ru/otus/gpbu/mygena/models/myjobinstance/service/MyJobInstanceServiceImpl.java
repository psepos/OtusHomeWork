package ru.otus.gpbu.mygena.models.myjobinstance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.myjobinstance.MyJobInstance;
import ru.otus.gpbu.mygena.models.myjobinstance.repository.MyJobInstanceRepository;

import java.util.List;

@Service
public class MyJobInstanceServiceImpl implements MyJobInstanceService {

    @Autowired
    private final MyJobInstanceRepository jobInstanceRepository;

    public MyJobInstanceServiceImpl(MyJobInstanceRepository jobInstanceRepository) {
        this.jobInstanceRepository = jobInstanceRepository;
    }

    @Override
    public List<MyJobInstance> findAll() {
        return jobInstanceRepository.findAll();
    }
}
