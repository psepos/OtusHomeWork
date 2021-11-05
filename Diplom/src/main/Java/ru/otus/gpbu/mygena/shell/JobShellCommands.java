package ru.otus.gpbu.mygena.shell;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.service.RuntimeEnvironmentGeneratorService;

@ShellComponent
public class JobShellCommands {
    @Autowired
    private RuntimeEnvironmentGeneratorService runtime;

    @Autowired
    private final JobOperator jobOperator;

    @Autowired
    private final JobExplorer jobExplorer;

    public JobShellCommands(RuntimeEnvironmentGeneratorService runtime, JobOperator jobOperator, JobExplorer jobExplorer) {
        this.runtime = runtime;
        this.jobOperator = jobOperator;
        this.jobExplorer = jobExplorer;
    }

    @ShellMethod(value = "showInfoJobs", key = "i")
    public void showInfoJobs() {
        System.out.println(jobExplorer.getJobNames());
        System.out.println(jobExplorer.getLastJobInstance("RuntimeEnvironmentGeneratorJob"));
    }

    @ShellMethod(value = "start-gen", key = "sg")
    public void startGen() throws Exception {
        Long executionId = jobOperator.start("RuntimeEnvironmentGeneratorJob", "");
        System.out.println(jobOperator.getSummary(executionId));
    }

}
