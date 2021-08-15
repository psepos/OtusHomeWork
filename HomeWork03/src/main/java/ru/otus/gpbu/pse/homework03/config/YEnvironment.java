package ru.otus.gpbu.pse.homework03.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "application")
@PropertySource("classpath:application.yml")
public class YEnvironment {

    @Value("${passingScore}")
    private Integer passingScore;

    @Value("${locale}")
    private String locale;

    @Value("${csvFile}")
    private String csvFile;

    @Value("${csvDelimiter}")
    private String csvDelimiter;


    public Integer getPassingScore() {
        return passingScore;
    }

    public String getLocale() {
        return locale;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public String getCsvDelimiter() {
        return csvDelimiter;
    }
}
