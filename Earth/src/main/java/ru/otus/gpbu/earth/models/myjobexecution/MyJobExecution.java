package ru.otus.gpbu.earth.models.myjobexecution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BATCH_JOB_EXECUTION")
public @Data
class MyJobExecution {

    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long Id;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "JOB_INSTANCE_ID")
    private Long jobInstanceId;

    @Column(name = "CREATE_TIME")
    @Transient
    private Timestamp createTime;

    @Column(name = "START_TIME")
    @Transient
    private Timestamp startTime;

    @Column(name = "END_TIME")
    @Transient
    private Timestamp endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    @Transient
    private Timestamp lastUpdated;

    @Column(name = "JOB_CONFIGURATION_LOCATION")
    private String jobConfigurationLocation;

}
