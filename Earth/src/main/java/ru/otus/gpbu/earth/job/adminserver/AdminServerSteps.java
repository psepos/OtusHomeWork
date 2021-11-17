package ru.otus.gpbu.earth.job.adminserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AdminServerSteps {

    private final StepBuilderFactory stepBuilderFactory;
    private final AdminServerTasklets tasklets;

    public AdminServerSteps(StepBuilderFactory stepBuilderFactory, AdminServerTasklets tasklets) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.tasklets = tasklets;
    }

    @Bean
    public Step runAdminServerStep() {
        return this.stepBuilderFactory
                .get("RunAdminServerStep")
                .tasklet(tasklets.runAdminServerTasklet())
                .build();
    }

    @Bean
    public Step installAdminServerStep() {
        return this.stepBuilderFactory
                .get("InstallAdminServerStep")
                .tasklet(tasklets.installAdminServerTasklet())
                .build();
    }
}
