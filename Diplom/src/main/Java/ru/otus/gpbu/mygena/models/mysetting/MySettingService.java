package ru.otus.gpbu.mygena.models.mysetting;

public interface MySettingService {
    String getSetting(String code);
    void setSetting(String code, String value);
}
