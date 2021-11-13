package ru.otus.gpbu.mygena.models.myjobexecution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@Slf4j
public class MyJobExecutionController {

    private final MyJobExecutionService service;

    public MyJobExecutionController(MyJobExecutionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MyJobExecution>> findAll() {

        try {
            List<MyJobExecution> all = service.findAll();
            return ResponseEntity.ok().body(all);
        } catch (Exception e) {
            log.error("findAll: ", e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
