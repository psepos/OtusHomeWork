package ru.otus.gpbu.pse.homework03.MyStudent.config;

public interface Environment {

    Integer getPassingScore();
    String getLocale();
    String getCsvFile();
    String getCsvDelimiter();

}
