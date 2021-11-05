package ru.otus.gpbu.mygena.job.runtimegeneration;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.service.runtime.GeneratorService;

import org.springframework.batch.item.ItemProcessor;

@Configuration
@Slf4j
public class Processors {

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityItemProcessor(GeneratorService generatorService){
        return generatorService::doEntityGenerate;
    }
}
