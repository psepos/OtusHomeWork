package ru.otus.gpbu.mygena.models.myentityattribute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.mygena.models.myentity.dto.MyEntityDto;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public @Data class MyEntityAttributeDto {

    private long id = -1;
    private String code;
    private String type;
    private MyEntityDto entity;

    public static MyEntityAttributeDto toDto(MyEntityAttribute attr){
        return new MyEntityAttributeDto(attr.getId(), attr.getCode(), attr.getType(), MyEntityDto.toDto(attr.getEntity()));
    }

    public static List<MyEntityAttributeDto> toDto(List<MyEntityAttribute> attributes){
        List<MyEntityAttributeDto> listDto = new ArrayList<>();

        for (MyEntityAttribute attrib : attributes){
            listDto.add(MyEntityAttributeDto.toDto(attrib));
        }
        return listDto;
    }
}
