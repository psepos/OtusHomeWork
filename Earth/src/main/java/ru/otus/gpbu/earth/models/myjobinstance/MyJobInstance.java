package ru.otus.gpbu.earth.models.myjobinstance;

import lombok.*;

import javax.persistence.*;


public
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_instance")
class MyJobInstance {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "guid")
    private String guid;

    @Column(name = "execution_id")
    private Long executionId;

    @Column(name = "parameters")
    private String parameters;

}
