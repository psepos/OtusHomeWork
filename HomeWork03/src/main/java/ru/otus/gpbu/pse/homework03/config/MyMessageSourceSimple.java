package ru.otus.gpbu.pse.homework03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MyMessageSourceSimple implements MyMessageSource{

    @Autowired
    private MessageSource msg;

    @Autowired
    private Environment env;

    @Override
    public String getMessage(String variable) {
        return msg.getMessage(variable, new String[]{}, Locale.forLanguageTag(env.getLocale()));
    }

    @Override
    public String getMessage(String variable, String param) {
        return msg.getMessage(variable, new String[]{param}, Locale.forLanguageTag(env.getLocale()));
    }
}
