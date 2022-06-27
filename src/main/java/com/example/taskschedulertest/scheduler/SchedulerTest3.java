package com.example.taskschedulertest.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerTest3 extends SchedulerRunner {

    private final TaskScheduler thirdTaskScheduler;

    public SchedulerTest3(TaskScheduler thirdTaskScheduler) {
        this.thirdTaskScheduler = thirdTaskScheduler;
    }
    public void scheduled5() {
        thirdTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled5");
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled5();
    }
}
