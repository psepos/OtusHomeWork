package ru.otus.gpbu.mygena.models.mysetting;

public interface MySettingService {
    String getSetting(String code);
    String getSetting(String code, String defaultValue);
    void setSetting(String code, String value);
}
