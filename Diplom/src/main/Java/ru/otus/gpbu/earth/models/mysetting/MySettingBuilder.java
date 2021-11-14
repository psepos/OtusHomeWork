package ru.otus.gpbu.earth.models.mysetting;

public class MySettingBuilder {

    private MySetting mySetting = new MySetting();

    public MySettingBuilder setCode(String code){
        this.mySetting.setCode(code);
        return this;
    }

    public MySettingBuilder setValue(String value){
        this.mySetting.setValue(value);
        return this;
    }

    public MySettingBuilder setDescription(String description){
        this.mySetting.setDescription(description);
        return this;
    }

    public MySetting build(){
        return mySetting;
    }
}
