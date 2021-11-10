package ru.otus.gpbu.mygena.models.myentity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.gpbu.mygena.models.myentity.dto.MyEntityDto;
import ru.otus.gpbu.mygena.models.myentity.service.MyEntityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/entities")
@Slf4j
public class MyEntityRestController {

    @Autowired
    private final MyEntityService myEntityService;

    public MyEntityRestController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @GetMapping
    public ResponseEntity<List<MyEntityDto>> findAllEntity() {

        try{
            List<MyEntityDto> all = myEntityService.findAll().stream().map(MyEntityDto::toDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(all);
        }
        catch (Exception e) {
            log.error("findAllEntity: ",e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
