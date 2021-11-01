package ru.otus.gpbu.mygena.models.myentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.otus.gpbu.mygena.models.myentityattribute.MyEntityAttribute;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entity")
@Getter
@Setter
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(targetEntity = MyEntityAttribute.class, mappedBy = "entity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MyEntityAttribute> attributes;

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
