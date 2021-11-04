package ru.otus.gpbu.mygena.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class RuntimeGenerationJob {

    private final Logger logger = LoggerFactory.getLogger("Batch");

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job RuntimeGeneration(
            Step clearTargetDirectory,
            Step copyTemplateEnvironmentToTargetDirectory,
            Step unzipTemplateEnvironment,
            Step generate,
            Step compileAndBuild) {
        return jobBuilderFactory
                .get("RuntimeGenerationJob")
                .start(clearTargetDirectory)
                .next(copyTemplateEnvironmentToTargetDirectory)
                .next(unzipTemplateEnvironment)
                .next(generate)
                .next(compileAndBuild)
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        logger.info("Начало RuntimeGenerationJob");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        logger.info("Конец RuntimeGenerationJob");
                    }
                })
                .build();
    }

}
