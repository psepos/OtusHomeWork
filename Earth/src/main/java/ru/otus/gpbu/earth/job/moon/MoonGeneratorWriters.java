package ru.otus.gpbu.earth.job.moon;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.earth.job.moon.writers.JavaFileWriter;
import ru.otus.gpbu.earth.service.patch.PathService;

@Configuration
@Slf4j
public class MoonGeneratorWriters {

    @Autowired
    private final PathService pathService;

    public MoonGeneratorWriters(PathService pathService) {
        this.pathService = pathService;
    }

    @StepScope
    @Bean
    public JavaFileWriter<JavaFile> myEntityWriter() {

        return new JavaFileWriter<>(pathService);
    }
}
