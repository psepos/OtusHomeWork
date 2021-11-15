package ru.otus.gpbu.earth.job.moon;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.earth.models.myentity.MyEntity;
import ru.otus.gpbu.earth.service.moon.MoonGeneratorService;

@Configuration
@Slf4j
public class MoonGeneratorProcessors {

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityItemProcessor(MoonGeneratorService generatorService){
        return generatorService::doEntityGenerate;
    }

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityRepositoryItemProcessor(MoonGeneratorService generatorService){
        return generatorService::doEntityRepositoriesGenerate;
    }

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityServiceItemProcessor(MoonGeneratorService generatorService){
        return generatorService::doEntityServicesGenerate;
    }

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityShellCommandsItemProcessor(MoonGeneratorService generatorService){
        return generatorService::doEntityShellCommandsGenerate;
    }

    @StepScope
    @Bean
    public ItemProcessor<MyEntity, JavaFile> myEntityRestControllersItemProcessor(MoonGeneratorService generatorService){
        return generatorService::myEntityRestControllersItemProcessor;
    }

}
