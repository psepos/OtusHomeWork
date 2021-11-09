package ru.otus.gpbu.mygena.job.runtimegeneration;

import com.squareup.javapoet.JavaFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.service.MySettingService;

@Configuration
@Slf4j
public class Steps {

    @Autowired
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    private final MySettingService settings;

    @Autowired
    private final Tasklets tasklets;

    public Steps(StepBuilderFactory stepBuilderFactory, MySettingService mySettingService, Tasklets tasklets) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.settings = mySettingService;
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

    @Bean
    public Step unzipTemplateEnvironmentStep(){
        return this.stepBuilderFactory
                .get("unzipTemplateEnvironmentStep")
                .tasklet(tasklets.unzipTemplateEnvironmentStepTasklet())
                .build();
    }

    @Bean
    public Step generateEntitiesStep(JpaPagingItemReader<MyEntity> myEntityReader,
                                     JavaFileWriter<JavaFile> myEntityWriter,
                                     ItemProcessor<MyEntity, JavaFile> myEntityItemProcessor){
        return this.stepBuilderFactory
                .get("generateEntitiesStep")
                .<MyEntity, JavaFile>chunk(settings.getSettingInt("GENERATOR.JOB.CHUNK_SIZE"))
                .reader(myEntityReader)
                .writer(myEntityWriter)
                .processor(myEntityItemProcessor)
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        log.info("generateEntitiesStep begin");
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        log.info("generateEntitiesStep end");
                        return new ExitStatus("Ok");
                    }
                })
                .build();
    }

    @Bean
    public Step generateEntitiesRepositoriesStep(JpaPagingItemReader<MyEntity> myEntityReader,
                                     JavaFileWriter<JavaFile> myEntityWriter,
                                     ItemProcessor<MyEntity, JavaFile> myEntityRepositoryItemProcessor){
        return this.stepBuilderFactory
                .get("generateEntitiesStep")
                .<MyEntity, JavaFile>chunk(settings.getSettingInt("GENERATOR.JOB.CHUNK_SIZE"))
                .reader(myEntityReader)
                .writer(myEntityWriter)
                .processor(myEntityRepositoryItemProcessor)
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        log.info("generateEntitiesRepositoriesStep begin");
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        log.info("generateEntitiesRepositoriesStep end");
                        return new ExitStatus("Ok");
                    }
                })
                .build();
    }

    @Bean
    public Step generateEntitiesServicesStep(JpaPagingItemReader<MyEntity> myEntityReader,
                                                 JavaFileWriter<JavaFile> myEntityWriter,
                                                 ItemProcessor<MyEntity, JavaFile> myEntityServiceItemProcessor){
        return this.stepBuilderFactory
                .get("generateEntitiesServicesStep")
                .<MyEntity, JavaFile>chunk(settings.getSettingInt("GENERATOR.JOB.CHUNK_SIZE"))
                .reader(myEntityReader)
                .writer(myEntityWriter)
                .processor(myEntityServiceItemProcessor)
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        log.info("generateEntitiesServicesStep begin");
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        log.info("generateEntitiesServicesStep end");
                        return new ExitStatus("Ok");
                    }
                })
                .build();
    }

    @Bean
    public Step generateEntityShellCommandsStep(
            JpaPagingItemReader<MyEntity> myEntityReader,
            JavaFileWriter<JavaFile> myEntityWriter,
            ItemProcessor<MyEntity, JavaFile> myEntityShellCommandsItemProcessor){
        return this.stepBuilderFactory
                .get("generateEntitiesServicesStep")
                .<MyEntity, JavaFile>chunk(settings.getSettingInt("GENERATOR.JOB.CHUNK_SIZE"))
                .reader(myEntityReader)
                .writer(myEntityWriter)
                .processor(myEntityShellCommandsItemProcessor)
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        log.info("generateEntityShellCommandsStep begin");
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        log.info("generateEntityShellCommandsStep end");
                        return new ExitStatus("Ok");
                    }
                })
                .build();
    }

    @Bean
    public Step compileAndBuildRuntimeStep(){
        return this.stepBuilderFactory
                .get("compileAndBuildRuntimeStep")
                .tasklet(tasklets.compileAndBuildRuntimeStepTasklet())
                .build();
    }
}
