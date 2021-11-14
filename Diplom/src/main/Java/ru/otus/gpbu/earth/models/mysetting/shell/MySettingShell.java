package ru.otus.gpbu.earth.models.mysetting.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingService;
import ru.otus.gpbu.earth.models.mysetting.service.MySettingServiceCrud;

@ShellComponent
public class MySettingShell {

    @Autowired
    private MySettingServiceCrud mySettingServiceCrud;

    @Autowired
    private MySettingService settings;

    @ShellMethod(value = "get-setting-by-id", key = "gsbi")
    public String getSettingById(Long id) {
        var setting = mySettingServiceCrud.findById(id);
        if (setting.isPresent()) {
            return setting.get().toString();
        } else {
            return "not found";
        }

    }

    @ShellMethod(value = "get-setting-all", key = "gsa")
    public String getSettingAll() {
        return mySettingServiceCrud.findAll().toString();
    }

    @ShellMethod(value = "get-setting", key = "gs")
    public String getSetting(String code) {
        return settings.getSetting(code);
    }

    @ShellMethod(value = "set-setting", key = "ss")
    public void setSetting(String code, String value) {
        settings.setSetting(code, value);
    }
}
