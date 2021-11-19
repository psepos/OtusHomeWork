package ru.otus.gpbu.earth.job.moon;

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
public class MoonJobs {

    @Autowired
    private final JobBuilderFactory jobBuilderFactory;

    public MoonJobs(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job moonEnvironmentGeneratorJob(
            Step clearTargetDirectoryStep,
            Step copyTemplateEnvironmentToTargetDirectoryStep,
            Step unzipTemplateEnvironmentStep,
            Step generateEntitiesStep,
            Step generateEntitiesRepositoriesStep,
            Step generateEntitiesServicesStep,
            Step generateEntityShellCommandsStep,
            Step generateEntityRestControllersStep,
            Step compileAndBuildRuntimeStep) {
        return jobBuilderFactory
                .get("MoonEnvironmentGeneratorJob")
                .start(clearTargetDirectoryStep)
                .next(copyTemplateEnvironmentToTargetDirectoryStep)
                .next(unzipTemplateEnvironmentStep)
                .next(generateEntitiesStep)
                .next(generateEntitiesRepositoriesStep)
                .next(generateEntitiesServicesStep)
                .next(generateEntityShellCommandsStep)
                .next(compileAndBuildRuntimeStep)
                .next(generateEntityRestControllersStep)
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

    @Bean
    public Job moonRunJob(Step moonRunStep) {
        return jobBuilderFactory
                .get("MoonRunJob")
                .start(moonRunStep)
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        log.info("moonRunJob begin");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        log.info("moonRunJob end");
                    }
                })
                .build();
    }
}
