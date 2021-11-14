package ru.otus.gpbu.earth.models.myentity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.models.myentityattribute.dto.MyEntityAttributeDto;

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

    public static MyEntity fromDto(MyEntityDto entity) {
        return new MyEntity(entity.getId(), entity.getCode(), entity.getDescription(), MyEntityAttributeDto.fromDto(entity.getAttributes()));
    }

}
