package ru.otus.gpbu.mygena.models.myentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyEntityServiceImpl implements MyEntityService {

    @Autowired
    private MyEntityRepository myEntityRepository;

    public MyEntityServiceImpl(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @Override
    public List<MyEntity> findAll() {
        return myEntityRepository.findAll();
    }

    @Override
    public Optional<MyEntity> findByCode(String code) {
        return myEntityRepository.findByCode(code);
    }

    @Override
    public void saveOrUpdate(MyEntity entity) {
        myEntityRepository.save(entity);
    }

    @Override
    public void delete(MyEntity entity) {
        myEntityRepository.delete(entity);
    }
}
