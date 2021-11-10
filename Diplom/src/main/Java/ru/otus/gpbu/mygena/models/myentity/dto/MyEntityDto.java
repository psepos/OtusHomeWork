package ru.otus.gpbu.mygena.models.myentity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentityattribute.dto.MyEntityAttributeDto;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public @Data class MyEntityDto {

    private long id = -1;
    private String code;
    private String description;
    private List<MyEntityAttributeDto> attributes;

    public static MyEntityDto toDto(MyEntity entity) {
        return new MyEntityDto(entity.getId(), entity.getCode(), entity.getDescription(), MyEntityAttributeDto.toDto(entity.getAttributes()));
    }
}
