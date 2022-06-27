package com.example.taskschedulertest.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerTest extends SchedulerRunner {

    private final TaskScheduler firstTaskScheduler;

    public SchedulerTest(TaskScheduler firstTaskScheduler) {
        this.firstTaskScheduler = firstTaskScheduler;
    }

    public void scheduled1() {
        firstTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled1");
        }, new CronTrigger("* * * * * *"));
    }

    public void scheduled2() {
        firstTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled2");
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled1();
        scheduled2();
    }

}
