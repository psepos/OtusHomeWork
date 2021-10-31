package ru.otus.gpbu.mygena.models.myentityattribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entity_attr")
@Getter
@Setter
public class MyEntityAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Override
    public String toString() {
        return "MyEntityAttribute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}