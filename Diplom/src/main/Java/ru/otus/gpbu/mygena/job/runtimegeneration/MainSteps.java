package ru.otus.gpbu.mygena.job.runtimegeneration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MainSteps {

    @Autowired
    private final StepBuilderFactory stepBuilderFactory;


    @Autowired
    private final MainTasklets tasklets;

    public MainSteps(StepBuilderFactory stepBuilderFactory, MainTasklets tasklets) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.tasklets = tasklets;
    }

    @Bean
    public Step clearTargetDirectoryStep(){
        return this.stepBuilderFactory
                .get("clearTargetDirectoryStep")
                .tasklet(tasklets.clearTargetDirectoryTasklet())
                .build();
    }

    @Bean
    public Step copyTemplateEnvironmentToTargetDirectoryStep(){
        return this.stepBuilderFactory
                .get("copyTemplateEnvironmentToTargetDirectoryStep")
                .tasklet(tasklets.copyTemplateEnvironmentToTargetDirectoryTasklet())
                .build();
    }


}
