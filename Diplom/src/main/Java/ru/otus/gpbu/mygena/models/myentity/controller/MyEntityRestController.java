package ru.otus.gpbu.mygena.models.myentity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
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

        try {
            List<MyEntityDto> all = myEntityService.findAll().stream().map(MyEntityDto::toDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(all);
        } catch (Exception e) {
            log.error("findAllEntity: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntityDto> findById(@PathVariable("id") long id) {
        return myEntityService
                .findById(id)
                .map(entity -> ResponseEntity.ok().body(MyEntityDto.toDto(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<Long> deleteEntity(@PathVariable Long id) {
        myEntityService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping
    public ResponseEntity<MyEntityDto> saveEntity(@Validated @RequestBody MyEntityDto entityDto) {
        MyEntity entity = MyEntityDto.fromDto(entityDto);
        try {
            myEntityService.saveOrUpdate(entity);
        } catch (Exception e) {
            log.error("saveEntity", e);
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(MyEntityDto.toDto(entity));
    }
}
