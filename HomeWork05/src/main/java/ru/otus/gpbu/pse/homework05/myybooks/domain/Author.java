package ru.otus.gpbu.pse.homework05.myybooks.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data
public class Author {
    private long id;
    private String name;
}
