package ru.otus.gpbu.mygena.models.mysetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MySettingShell {

    @Autowired
    private MySettingService mySettingService;

    @ShellMethod(value = "get-setting-by-id", key = "gsbi")
    public String getSettingById(Long id) {
        return mySettingService.findById(id).get().toString();
    }

    @ShellMethod(value = "get-setting-all", key = "gsa")
    public String getSettingAll() {
        return mySettingService.findAll().toString();
    }

    @ShellMethod(value = "get-setting", key = "gs")
    public String getSetting(String code) {
        return mySettingService.getSetting(code);
    }

    @ShellMethod(value = "set-setting", key = "ss")
    public void setSetting(String code, String value) {
        mySettingService.setSetting(code, value);
    }
}
