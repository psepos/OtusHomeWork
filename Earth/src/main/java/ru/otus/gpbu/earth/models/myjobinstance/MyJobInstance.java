package ru.otus.gpbu.earth.models.myjobinstance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


public
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BATCH_JOB_INSTANCE")
class MyJobInstance {

    @Column(name = "JOB_INSTANCE_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "VERSION")
    private long version;

    @Column(name = "JOB_NAME")
    private String name;

    @Column(name = "JOB_KEY")
    private String key;

}
