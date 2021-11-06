package ru.otus.gpbu.mygena.models.mysetting;

public interface MySettingService {
    String getSetting(String code);
    String getSetting(String code, String defaultValue);
    int getSettingInt(String code);
    boolean getSettingBool(String code);
    void setSetting(String code, String value);
}
