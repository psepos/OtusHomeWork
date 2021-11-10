package ru.otus.gpbu.mygena.models.mysetting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.mygena.models.mysetting.MySetting;
import ru.otus.gpbu.mygena.models.mysetting.dto.MySettingDto;
import ru.otus.gpbu.mygena.models.mysetting.service.MySettingServiceCrud;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/settings")
@Slf4j
public class MySettingRestController {

    @Autowired
    private final MySettingServiceCrud service;

    public MySettingRestController(MySettingServiceCrud service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MySettingDto>> findAllSettings() {

        try{
            List<MySettingDto> all = service.findAll().stream().map(MySettingDto::toDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(all);
        }
        catch (Exception e) {
            log.error("findAllSettings: ",e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MySettingDto> findSettingById(@PathVariable long id) {
        return service.findById(id).map(mySetting -> ResponseEntity.ok().body(MySettingDto.toDto(mySetting))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MySettingDto> saveSetting(@Validated @RequestBody MySetting setting){
        service.saveOrUpdate(setting);
        return ResponseEntity.ok().body(MySettingDto.toDto(setting));
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.DELETE })
    public ResponseEntity<Long> deleteSetting(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().body(id);
    }
}
