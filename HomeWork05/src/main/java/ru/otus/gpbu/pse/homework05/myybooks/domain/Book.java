package ru.otus.gpbu.pse.homework05.myybooks.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Book {
    private long id;
    private String name;
    private Genre genre;
    private Author author;
}
