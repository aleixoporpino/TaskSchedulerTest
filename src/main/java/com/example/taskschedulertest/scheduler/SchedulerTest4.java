package com.example.taskschedulertest.scheduler;

import com.example.taskschedulertest.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SchedulerTest4 extends SchedulerRunner {

    private final TaskScheduler fourthTaskScheduler;

    public SchedulerTest4(TaskScheduler fourthTaskScheduler) {
        this.fourthTaskScheduler = fourthTaskScheduler;
    }

    public void scheduled6() {
        fourthTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled6");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled6();
    }
}
