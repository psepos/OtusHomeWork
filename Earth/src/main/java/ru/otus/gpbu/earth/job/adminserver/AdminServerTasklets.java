package ru.otus.gpbu.earth.job.adminserver;

import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.gpbu.earth.service.adminserver.AdminServerService;

@Configuration
public class AdminServerTasklets {

    private final AdminServerService adminServerService;

    public AdminServerTasklets(AdminServerService adminServerService) {
        this.adminServerService = adminServerService;
    }

    @Bean
    public MethodInvokingTaskletAdapter runAdminServerTasklet() {

        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(adminServerService);
        adapter.setTargetMethod("run");

        return adapter;
    }

    @Bean
    public MethodInvokingTaskletAdapter installAdminServerTasklet() {

        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();

        adapter.setTargetObject(adminServerService);
        adapter.setTargetMethod("install");

        return adapter;
    }
}
