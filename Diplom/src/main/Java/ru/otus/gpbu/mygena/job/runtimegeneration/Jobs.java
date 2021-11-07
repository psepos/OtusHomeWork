package ru.otus.gpbu.mygena.job.runtimegeneration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
@Slf4j
public class Jobs {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job RuntimeEnvironmentGeneratorJob(
            Step clearTargetDirectoryStep,
            Step copyTemplateEnvironmentToTargetDirectoryStep,
            Step unzipTemplateEnvironmentStep,
            Step generateEntitiesStep,
            Step generateEntitiesRepositoriesStep,
            Step generateEntitiesServicesStep,
            Step compileAndBuildRuntimeStep) {
        return jobBuilderFactory
                .get("RuntimeEnvironmentGeneratorJob")
                .start(clearTargetDirectoryStep)
                .next(copyTemplateEnvironmentToTargetDirectoryStep)
                .next(unzipTemplateEnvironmentStep)
                .next(generateEntitiesStep)
                .next(generateEntitiesRepositoriesStep)
                .next(generateEntitiesServicesStep)
                .next(compileAndBuildRuntimeStep)
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        log.info("Begin");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        log.info("End");
                    }
                })
                .build();
    }


}
