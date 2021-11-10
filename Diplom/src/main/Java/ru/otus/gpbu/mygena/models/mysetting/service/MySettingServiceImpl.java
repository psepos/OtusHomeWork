package ru.otus.gpbu.mygena.models.mysetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.gpbu.mygena.models.mysetting.MySetting;
import ru.otus.gpbu.mygena.models.mysetting.MySettingBuilder;
import ru.otus.gpbu.mygena.models.mysetting.repository.MySettingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class MySettingServiceImpl implements MySettingService, MySettingServiceCrud {

    @Autowired
    private MySettingRepository mySettingRepository;

    public MySettingServiceImpl(MySettingRepository mySettingRepository) {
        this.mySettingRepository = mySettingRepository;
    }

    @Override
    public Optional<MySetting> findById(Long id) {
        return mySettingRepository.findById(id);
    }

    @Override
    public Optional<MySetting> findByCode(String code) {
        return mySettingRepository.findByCode(code);
    }

    @Override
    public List<MySetting> findAll() {
        return mySettingRepository.findAll();
    }

    @Override
    public void saveOrUpdate(MySetting setting) {
        mySettingRepository.save(setting);
    }

    @Override
    public void deleteById(Long id) {
        mySettingRepository.deleteById(id);
    }

    @Override
    public String getSetting(String code) {
        return getSetting(code, "");
    }

    @Override
    public String getSetting(String code, String defaultValue) {
        String result;

        Optional<MySetting> setting = mySettingRepository.findByCode(code);

        if (setting.isPresent()){
            result = setting.get().getValue();
        } else
        {
            result = defaultValue;
        }

        return result;
    }

    @Override
    public int getSettingInt(String code) {
        return Integer.parseInt(getSetting(code));
    }

    @Override
    public boolean getSettingBool(String code) {
        String setting = getSetting(code).toUpperCase(Locale.ROOT);
        return setting.equals("YES") || setting.equals("TRUE") || setting.equals("ДА");
    }

    @Override
    @Transactional
    public void setSetting(String code, String value) {
        Optional<MySetting> settingOpt = mySettingRepository.findByCode(code);

        if (settingOpt.isPresent()) {
            settingOpt.get().setValue(value);
            mySettingRepository.save(settingOpt.get());
        } else{
            MySetting setting = new MySettingBuilder()
                    .setCode(code)
                    .setValue(value)
                    .setDescription("")
                    .build();
            mySettingRepository.save(setting);
        }
    }

}