package ru.otus.gpbu.earth.models.myentityattribute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.myentity.repository.MyEntityRepository;
import ru.otus.gpbu.earth.models.myentityattribute.MyEntityAttribute;
import ru.otus.gpbu.earth.models.myentityattribute.repository.MyEntityAttributeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyEntityAttributeServiceImpl implements MyEntityAttributeService {

    @Autowired
    private final MyEntityAttributeRepository myEntityAttributeRepository;

    @Autowired
    private final MyEntityRepository myEntityRepository;

    public MyEntityAttributeServiceImpl(MyEntityAttributeRepository myEntityAttributeRepository, MyEntityRepository myEntityRepository) {
        this.myEntityAttributeRepository = myEntityAttributeRepository;
        this.myEntityRepository = myEntityRepository;
    }


    @Override
    public List<MyEntityAttribute> getEntityAttributes(String EntityCode) {
        Optional<MyEntity> entityOpt = myEntityRepository.findByCode(EntityCode);

        if (entityOpt.isEmpty()) {
            return new ArrayList<>();
        }

        MyEntity entity = entityOpt.get();

        return myEntityAttributeRepository.findAllByEntity(entity);
    }
}
