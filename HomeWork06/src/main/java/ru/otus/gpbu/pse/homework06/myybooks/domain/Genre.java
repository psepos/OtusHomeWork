package ru.otus.gpbu.pse.homework06.myybooks.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Genre {
    private long id;
    private String name;
}
