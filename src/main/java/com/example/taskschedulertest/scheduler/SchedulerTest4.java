package com.example.taskschedulertest.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerTest4 extends SchedulerRunner {

    private final TaskScheduler fourthTaskScheduler;

    public SchedulerTest4(TaskScheduler fourthTaskScheduler) {
        this.fourthTaskScheduler = fourthTaskScheduler;
    }

    public void scheduled6() {
        fourthTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled6");
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled6();
    }
}
