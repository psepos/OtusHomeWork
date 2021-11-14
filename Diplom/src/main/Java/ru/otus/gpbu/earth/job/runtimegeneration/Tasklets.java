package ru.otus.gpbu.earth.job.runtimegeneration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.earth.service.MoonRuntimeOperations;

@Configuration
@Slf4j
public class Tasklets {

    @Autowired
    private final MoonRuntimeOperations moonRuntimeOperations;

    public Tasklets(MoonRuntimeOperations moonRuntimeOperations) {
        this.moonRuntimeOperations = moonRuntimeOperations;
    }


    @Bean
    public MethodInvokingTaskletAdapter clearTargetDirectoryTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(moonRuntimeOperations);
        adapter.setTargetMethod("clearTargetDirectory");

        return adapter;

    }

    @Bean
    public MethodInvokingTaskletAdapter copyTemplateEnvironmentToTargetDirectoryTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(moonRuntimeOperations);
        adapter.setTargetMethod("copyTemplateEnvironmentToTargetDirectory");

        return adapter;

    }

    @Bean
    public MethodInvokingTaskletAdapter unzipTemplateEnvironmentStepTasklet(){
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(moonRuntimeOperations);
        adapter.setTargetMethod("unzipTemplateEnvironment");

        return adapter;

    }

    @Bean
    public Tasklet compileAndBuildRuntimeStepTasklet() {
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(moonRuntimeOperations);
        adapter.setTargetMethod("compileAndBuildRuntimeStep");

        return adapter;
    }
}
