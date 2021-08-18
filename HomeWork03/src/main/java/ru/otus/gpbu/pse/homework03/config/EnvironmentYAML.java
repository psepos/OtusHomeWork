package ru.otus.gpbu.pse.homework03.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@PropertySource("classpath:application.yml")
@Component
public class EnvironmentYAML implements Environment {

    @Getter @Setter
    private Integer passingScore;

    @Getter @Setter
    private String locale;

    @Getter @Setter
    private String csvFile;

    @Getter @Setter
    private String csvDelimiter;

}
