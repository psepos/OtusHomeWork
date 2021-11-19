package ru.otus.gpbu.earth.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response <T> {
    private T body;
    private String link;
}
