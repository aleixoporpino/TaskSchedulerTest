package com.example.taskschedulertest.scheduler;

import com.example.taskschedulertest.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SchedulerTest extends SchedulerRunner {

    private final TaskScheduler firstTaskScheduler;

    public SchedulerTest(TaskScheduler firstTaskScheduler) {
        this.firstTaskScheduler = firstTaskScheduler;
    }

    public void scheduled1() {
        firstTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled1");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    public void scheduled2() {
        firstTaskScheduler.schedule(() -> {
            log.info(new Date() + " " + Thread.currentThread().getName() + ": scheduled2");
            Utils.sleep();
        }, new CronTrigger("* * * * * *"));
    }

    @Override
    public void run() {
        scheduled1();
        scheduled2();
    }

}
