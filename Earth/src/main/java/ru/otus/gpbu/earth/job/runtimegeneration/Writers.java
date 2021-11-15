package ru.otus.gpbu.earth.job.runtimegeneration;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.earth.service.PathService;

@Configuration
@Slf4j
public class Writers {

    @Autowired
    private final PathService pathService;

    public Writers(PathService pathService) {
        this.pathService = pathService;
    }

    @StepScope
    @Bean
    public JavaFileWriter<JavaFile> myEntityWriter() {

        return new JavaFileWriter<>(pathService);
    }
}
