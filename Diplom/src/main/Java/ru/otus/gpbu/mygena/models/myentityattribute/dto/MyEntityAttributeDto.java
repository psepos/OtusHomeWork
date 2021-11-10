package ru.otus.gpbu.mygena.models.myentityattribute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class MyEntityAttributeDto {

    private long id = -1;
    private String code;
    private String type;

    public static MyEntityAttributeDto toDto(MyEntityAttribute attr) {
        return new MyEntityAttributeDto(attr.getId(), attr.getCode(), attr.getType());
    }

    public static List<MyEntityAttributeDto> toDto(List<MyEntityAttribute> attributes) {
        List<MyEntityAttributeDto> listDto = new ArrayList<>();

        for (MyEntityAttribute attrib : attributes) {
            listDto.add(MyEntityAttributeDto.toDto(attrib));
        }
        return listDto;
    }

    public static MyEntityAttribute fromDto(MyEntityAttributeDto attrDto) {
        return new MyEntityAttribute(attrDto.getId(), attrDto.getCode(), attrDto.getType(), new MyEntity());
    }

    public static List<MyEntityAttribute> fromDto(List<MyEntityAttributeDto> attributes) {
        List<MyEntityAttribute> list = new ArrayList<>();

        for (MyEntityAttributeDto attribDto : attributes) {
            list.add(MyEntityAttributeDto.fromDto(attribDto));
        }
        return list;
    }
}
