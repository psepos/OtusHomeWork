package ru.otus.gpbu.pse.homework04.config;

public interface Environment {

    Integer getPassingScore();
    String getLocale();
    String getCsvFile();
    String getCsvDelimiter();

}
