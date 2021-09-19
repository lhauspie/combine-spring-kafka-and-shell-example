package com.example.batchprocessing;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BatchCommands {

    private SimpleJobLauncher simpleJobLauncher;
    private Job importUserJob;

    public BatchCommands(SimpleJobLauncher simpleJobLauncher, Job importUserJob) {
        this.simpleJobLauncher = simpleJobLauncher;
        this.importUserJob = importUserJob;
    }

    @ShellMethod(key="import-user", value = "Import users from file")
    public String importUser(
            @ShellOption String parameter,
            @ShellOption(defaultValue = "") String filter
    ) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters param = new JobParametersBuilder()
                .addString("parameter", parameter)
                .addString("filter", filter, false)
                .toJobParameters();

        JobExecution execution = null;
        execution = simpleJobLauncher.run(importUserJob, param);
        System.out.println("execution status : " + execution.getStatus());
        return execution.getStatus().name();
    }

    @ShellMethod(key="hello", value = "Just say hello")
    public String hello(
            @ShellOption(defaultValue = "World") String who
    ) {
        return "Hello " + who + " !";
    }
}