package ru.otus.gpbu.earth.models.mysetting.service;

public interface MySettingService {
    String getSetting(String code);
    String getSetting(String code, String defaultValue);
    int getSettingInt(String code);
    boolean getSettingBool(String code);
    void setSetting(String code, String value);
}
