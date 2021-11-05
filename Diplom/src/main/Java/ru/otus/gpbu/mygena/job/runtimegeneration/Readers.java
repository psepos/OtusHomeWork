package ru.otus.gpbu.mygena.job.runtimegeneration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.mygena.models.myentity.MyEntity;
import ru.otus.gpbu.mygena.models.mysetting.MySettingService;

import javax.persistence.EntityManagerFactory;

@Configuration
@Slf4j
public class Readers {

    @Autowired
    private final MySettingService mySettingService;

    @Autowired
    private final EntityManagerFactory entityManagerFactory;

    public Readers(MySettingService mySettingService, EntityManagerFactory entityManagerFactory) {
        this.mySettingService = mySettingService;
        this.entityManagerFactory = entityManagerFactory;
    }

    @StepScope
    @Bean
    public JpaPagingItemReader<MyEntity> myEntityReader() {
        return new JpaPagingItemReaderBuilder<MyEntity>()
                .name("myEntityReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString(mySettingService.getSetting("GENERATOR.JOB.JPA_PAGING_ITEM_READER.QUERY_STRING"))
                .pageSize(mySettingService.getSettingInt("GENERATOR.JOB.JPA_PAGING_ITEM_READER.PAGE_SIZE"))
                .build();
    }
}
