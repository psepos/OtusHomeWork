package ru.otus.gpbu.mygena.models.myentity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.gpbu.mygena.models.myentity.service.MyEntityService;

@RestController
@RequestMapping("/api/v1/entities")
@Slf4j
public class MyEntityRestController {

    @Autowired
    private final MyEntityService myEntityService;

    public MyEntityRestController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }
}
