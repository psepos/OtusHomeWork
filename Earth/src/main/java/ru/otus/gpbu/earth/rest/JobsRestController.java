package ru.otus.gpbu.earth.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.gpbu.earth.models.myjobexecution.MyJobExecutionService;
import ru.otus.gpbu.earth.models.myjobinstance.MyJobInstance;
import ru.otus.gpbu.earth.models.myjobinstance.service.MyJobInstanceService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@Slf4j
public class JobsRestController {

    private final MyJobInstanceService jobInstanceService;
    private final MyJobExecutionService jobExecutionService;
    private final JobOperator jobOperator;

    public JobsRestController(MyJobInstanceService jobInstanceService,
                              MyJobExecutionService jobExecutionService, JobOperator jobOperator) {
        this.jobInstanceService = jobInstanceService;
        this.jobExecutionService = jobExecutionService;
        this.jobOperator = jobOperator;
    }

    @GetMapping
    public ResponseEntity<List<String>> findAllInstances() {
        try {
            List<String> all = new ArrayList<>(jobOperator.getJobNames());
            return ResponseEntity.ok().body(all);
        } catch (Exception e) {
            log.error("findAll: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }
/*
    @GetMapping("/{jobName}/executions")
    public ResponseEntity<List<MyJobExecution>> findAllExecutions(@PathVariable String jobName) {
        try {
            List<MyJobInstance> all = jobInstanceService.findAll();
            return ResponseEntity.ok().body(all);
        } catch (Exception e) {
            log.error("findAll: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }
*/
    @PostMapping("/{jobName}/start")
    public ResponseEntity<String> startJob(@Validated @RequestBody String jobName) {

        try {
            Long executionId = jobOperator.start(jobName, "start = " + LocalDateTime.now());
            return ResponseEntity.ok().body(jobOperator.getSummary(executionId));
        } catch (Exception e) {
            log.error("Error running job {}", jobName, e);
            return ResponseEntity.ok().body("Job failed");
        }
    }
}
