package com.example.taskschedulertest.scheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerTest2 extends SchedulerRunner {

    private final TaskScheduler secondTaskScheduler;

    public SchedulerTest2(TaskScheduler secondTaskScheduler) {
        this.secondTaskScheduler = secondTaskScheduler;
    }

    public void scheduled3() {
        secondTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled3");
        }, new CronTrigger("* * * * * *"));
    }

    public void scheduled4() {
        secondTaskScheduler.schedule(() -> {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + ": scheduled4");
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled3();
        scheduled4();
    }
}
