package ru.otus.gpbu.pse.homework04.MyStudent.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@PropertySource("classpath:application.yml")
@Component
@Getter @Setter
public class EnvironmentYAML implements Environment {

    private Integer passingScore;

    private String locale;

    private String csvFile;

    private String csvDelimiter;

}
