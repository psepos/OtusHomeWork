package ru.otus.gpbu.mygena.models.mysetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.gpbu.mygena.models.mysetting.dto.MySettingDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MySettingController {

    @Autowired
    private final MySettingServiceCrud service;

    public MySettingController(MySettingServiceCrud service) {
        this.service = service;
    }

    @GetMapping("/api/settings")
    public List<MySettingDto> findAllSettings(){
        return service.findAll().stream().map(MySettingDto::toDto).collect(Collectors.toList());
    }

}
