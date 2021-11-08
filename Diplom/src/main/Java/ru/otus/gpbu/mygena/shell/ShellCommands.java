package ru.otus.gpbu.mygena.shell;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.gpbu.mygena.common.StringHelper;
import ru.otus.gpbu.mygena.service.PathService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@ShellComponent
public class ShellCommands {

    @Autowired
    private final JobOperator jobOperator;

    @Autowired
    private final JobExplorer jobExplorer;

    @Autowired
    private final PathService path;

    public ShellCommands(JobOperator jobOperator, JobExplorer jobExplorer, PathService path) {
        this.jobOperator = jobOperator;
        this.jobExplorer = jobExplorer;
        this.path = path;
    }

    @ShellMethod(value = "showInfoJobs", key = "i")
    public void showInfoJobs() {
        System.out.println(jobExplorer.getJobNames());
        System.out.println(jobExplorer.getLastJobInstance("RuntimeEnvironmentGeneratorJob"));
    }

    @ShellMethod(value = "start-gen", key = "sg")
    public void startGen() throws Exception {
        Long executionId = jobOperator.start("RuntimeEnvironmentGeneratorJob", "start = " + LocalDateTime.now());
        System.out.println(jobOperator.getSummary(executionId));
    }

    @ShellMethod(value = "run", key = "r")
    public void runtimeRun() throws IOException {

        String command = "cmd /c start java -jar " + path.artifactPath() + "\\" + path.artifactFileName();

        Runtime.getRuntime().exec(
                command,
                null,
                new File(path.runtimeEnvironmentDestinationPath().toString()));

    }

}