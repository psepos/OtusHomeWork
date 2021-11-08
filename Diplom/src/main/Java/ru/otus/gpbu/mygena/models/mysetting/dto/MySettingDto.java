package ru.otus.gpbu.mygena.models.mysetting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.mygena.models.mysetting.MySetting;

@NoArgsConstructor
@AllArgsConstructor
public @Data class MySettingDto {
    private long id = -1;
    private String code;
    private String description;
    private String value;

    public static MySettingDto toDto(MySetting setting){
        return new MySettingDto(setting.getId(), setting.getCode(), setting.getDescription(), setting.getValue());
    }
}
