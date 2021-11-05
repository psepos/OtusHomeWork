package ru.otus.gpbu.mygena.job.runtimegeneration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.mygena.service.RuntimeEnvironmentGeneratorService;

@Configuration
@Slf4j
public class Tasklets {

    @Autowired
    private final RuntimeEnvironmentGeneratorService runtimeEnvironmentService;

    public Tasklets(RuntimeEnvironmentGeneratorService runtimeEnvironmentService) {
        this.runtimeEnvironmentService = runtimeEnvironmentService;
    }

    @Bean
    public MethodInvokingTaskletAdapter clearTargetDirectoryTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(runtimeEnvironmentService);
        adapter.setTargetMethod("clearTargetDirectory");

        return adapter;

    }

    @Bean
    public MethodInvokingTaskletAdapter copyTemplateEnvironmentToTargetDirectoryTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(runtimeEnvironmentService);
        adapter.setTargetMethod("copyTemplateEnvironmentToTargetDirectory");

        return adapter;

    }

    @Bean
    public MethodInvokingTaskletAdapter unzipTemplateEnvironmentStepTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(runtimeEnvironmentService);
        adapter.setTargetMethod("unzipTemplateEnvironment");

        return adapter;

    }
}
