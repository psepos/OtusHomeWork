package ru.otus.gpbu.pse.homework03.test.config;

import org.springframework.stereotype.Component;
import ru.otus.gpbu.pse.homework03.config.Environment;

@Component
public class EnvironmentTest implements Environment {

    @Override
    public Integer getPassingScore() {
        return 3;
    }

    @Override
    public String getLocale() {
        return "en-EN";
    }

    @Override
    public String getCsvFile() {
        return "";
    }

    @Override
    public String getCsvDelimiter() {
        return ";";
    }
}
