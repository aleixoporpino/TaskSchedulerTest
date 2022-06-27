package com.example.taskschedulertest.scheduler;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class SchedulerRunner implements Runnable {

    @PostConstruct
    private void postConstruct() {
        run();
    }
}
