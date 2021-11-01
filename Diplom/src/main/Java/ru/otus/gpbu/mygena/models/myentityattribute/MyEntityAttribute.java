package ru.otus.gpbu.mygena.models.myentityattribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;

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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MyEntity.class)
    @JoinColumn(name = "entity_id")
    private MyEntity entity;

    @Override
    public String toString() {
        return "MyEntityAttribute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
